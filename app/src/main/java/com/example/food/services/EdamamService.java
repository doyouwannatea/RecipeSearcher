package com.example.food.services;

import com.example.food.apis.EdamamApi;
import com.example.food.models.RecipeSearchModel;

import okhttp3.OkHttpClient;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class EdamamService {
    private static final String BASE_URL = "https://api.edamam.com";
    private static final String KEY = "9eabbbfe991b75aa2b9e212aba7461f6";
    private static final String ID = "c4790857";
    private OkHttpClient client;

    private static EdamamService mInstance;
    private EdamamApi edamamApi;

    private EdamamService() {
        client = new OkHttpClient();
        edamamApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EdamamApi.class);
    }

    public static EdamamService getInstance() {
        if (mInstance == null) {
            mInstance = new EdamamService();
        }
        return mInstance;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public Call<RecipeSearchModel> getRecipesByQ(String searchValue) {
        return edamamApi.getRecipesByQ(ID, KEY, searchValue);
    }
}
