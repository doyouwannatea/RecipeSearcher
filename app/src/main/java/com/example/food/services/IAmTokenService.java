package com.example.food.services;

import com.example.food.apis.IAmTokenApi;
import com.example.food.models.IAmTokenModel;
import com.example.food.models.IAmTokenResBody;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IAmTokenService {
    private final String OAuth = "AQAAAABU0_4JAATuwYmht9GkqUcXuqTDSl001Ec";
    private final String BASE_URL = "https://iam.api.cloud.yandex.net/iam/v1/tokens/";

    private static IAmTokenService mInstance;
    private IAmTokenApi iAmTokenApi;

    private IAmTokenService() {
        iAmTokenApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IAmTokenApi.class);
    }

    public static IAmTokenService getInstance() {
        if (mInstance == null) {
            mInstance = new IAmTokenService();
        }
        return mInstance;
    }

    public Call<IAmTokenModel> getToken() {
        return iAmTokenApi.getToken(new IAmTokenResBody(OAuth));
    }
}
