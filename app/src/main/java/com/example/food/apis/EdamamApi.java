package com.example.food.apis;

import com.example.food.models.RecipeSearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("/search")
    Call<RecipeSearchModel> getRecipesByQ(
            @Query("app_id") String appId,
            @Query("app_key") String appKey,
            @Query("q") String q
    );
}

