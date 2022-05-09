package com.example.finalproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Myretrofit {
    @GET("countries")
        Call<List<MyDataSet>> getDataSet();
}
