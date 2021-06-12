package com.example.food.services;

import com.example.food.apis.IAmTokenApi;
import com.example.food.apis.TranslateApi;
import com.example.food.models.IAmTokenModel;
import com.example.food.models.IAmTokenResBody;
import com.example.food.models.TranslateModel;
import com.example.food.models.TranslateResBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslateService {
    private final String BASE_URL = "https://translate.api.cloud.yandex.net/";
    private String AUTHORIZATION = "";
    private final String FOLDER_ID = "b1gbridgu5v2i19msrfq";
    private final String TARGET_LANG = "en";

    private static TranslateService mInstance;
    private TranslateApi translateApi;

    private TranslateService() {
        translateApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TranslateApi.class);
    }

    public static TranslateService getInstance() {
        if (mInstance == null) {
            mInstance = new TranslateService();
        }
        return mInstance;
    }

    public void setToken(String token) {
        AUTHORIZATION = "Bearer " + token;
    }

    public Call<TranslateModel> translate(String[] texts) {
        TranslateResBody body = new TranslateResBody(FOLDER_ID, TARGET_LANG, texts);
        return translateApi.translate(AUTHORIZATION, body);
    }
}