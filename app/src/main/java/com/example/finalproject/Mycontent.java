/* Name:Mycontent.java
   Due Date:4/24/2020
   Description: This program is basically Navigation Drawer and Consuming Data with Retrofit. In this program I used a NAVIGATION DRAWER,Consumes data from a web service
                and Uses of RecyclerView.I used retrofit to conusme data from the requied API and at the vehical tab in the navigation drawer three field is displayed
                in which the API's vehicle name, vehical type and description is displayed.



*/




package com.example.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mycontent extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycontent);
        recyclerView = findViewById(R.id.myrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.covid19api.com/").addConverterFactory(GsonConverterFactory.create()).build();
        Myretrofit myretrofit = retrofit.create(Myretrofit.class);
        Call<List<MyDataSet>> mylistcall = myretrofit.getDataSet();
        mylistcall.enqueue(new Callback<List<MyDataSet>>() {
            @Override
            public void onResponse(Call<List<MyDataSet>> call, Response<List<MyDataSet>> response) {
                ShowData(response.body());

            }

            @Override
            public void onFailure(Call<List<MyDataSet>> call, Throwable t) {

            }
        });
    }

    private void ShowData(List<MyDataSet> response) {
        MyAdapter myAdapter = new MyAdapter(response,getApplicationContext());
        recyclerView.setAdapter(myAdapter);
    }
}
