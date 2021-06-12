package com.example.food.apis;

import com.example.food.models.IAmTokenModel;
import com.example.food.models.IAmTokenResBody;
import com.example.food.models.TranslateModel;
import com.example.food.models.TranslateResBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;

import retrofit2.http.POST;

public interface TranslateApi {
    @POST("/translate/v2/translate/")
    Call<TranslateModel> translate(
            @Header("Authorization") String authorization,
            @Body TranslateResBody body
    );
}

