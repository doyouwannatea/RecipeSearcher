package com.example.food.apis;

import com.example.food.models.IAmTokenModel;
import com.example.food.models.IAmTokenResBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAmTokenApi {
    @POST(".")
    Call<IAmTokenModel> getToken(@Body IAmTokenResBody body);
}
