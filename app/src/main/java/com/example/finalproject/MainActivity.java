/* Name:MainActivity.java
   Due Date:5/08/2020
   Description: This is the main java file , The purpose of this application is to provide self checking method for the COVID-19 , where people
   can get some information related to it.



*/





package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cntnu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cntnu = findViewById(R.id.cntnu);

        cntnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startquestions();
            }
        });

    }

    private void startquestions() {
        Intent intent= new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
