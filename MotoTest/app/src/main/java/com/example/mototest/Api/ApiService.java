package com.example.mototest.Api;

import com.example.mototest.Model.Test;
import com.example.mototest.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    Call<Test> getTest(@Query("action") String action,
                       @Query("idtest") String idtest);
    @GET("api")
    Call<Alltest> getAllTest(@Query("action") String action);

    @FormUrlEncoded
    @POST("api")
    Call<User> login(
            @Field("Username") String username,
            @Field("Password") String password
    );

    @FormUrlEncoded
    @POST("api")
    Call<User> register(
            @Field("Name") String name,
            @Field("Username") String username,
            @Field("Password") String password
    );
}
