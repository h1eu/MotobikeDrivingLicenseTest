package com.example.mototest.Api;

import com.example.mototest.Model.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

//https://btl60pm2.000webhostapp.com/api
public interface ApiService {
    Gson gson = new GsonBuilder().create();
    ApiService apiservice = new Retrofit.Builder()
            .baseUrl("https://btl60pm2.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("api")
    Call<Test> getTest(@Query("test_key") String test_key,
                       @Query("type") String type);
}
