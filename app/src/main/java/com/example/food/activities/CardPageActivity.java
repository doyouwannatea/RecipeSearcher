package com.example.food.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food.R;
import com.example.food.models.Ingredient;
import com.example.food.models.RecipeModel;
import com.example.food.models.RecipeSearchModel;
import com.example.food.models.TranslateModel;
import com.example.food.services.TranslateService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardPageActivity extends AppCompatActivity implements View.OnClickListener {

    private RecipeModel recipe;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_page);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        Gson gson = new Gson();
        recipe = gson.fromJson(getIntent().getStringExtra("recipe"), RecipeModel.class);

        titleView = findViewById(R.id.title);
        ImageView image = findViewById(R.id.image);
        TextView calView = findViewById(R.id.cal);
        TextView ingrCount = findViewById(R.id.ingrCount);
        TextView cuisineTypeView = findViewById(R.id.cuisineTypeView);
        LinearLayout ingrList = findViewById(R.id.ingrList);
        Button btnLink = findViewById(R.id.linkBtn);

        btnLink.setOnClickListener(this);

        if (recipe.getCuisineTypes().isEmpty()) {
            cuisineTypeView.setVisibility(View.GONE);
        }
        cuisineTypeView.setText(recipe.getCuisineTypes());
        titleView.setText(recipe.getLabel());
        calView.setText(recipe.getCalories());

        Glide.with(this)
                .load(recipe.getImage())
                .placeholder(R.drawable.food_placeholder)
                .into(image);

        ingrCount.setText("Quantity: " + recipe.getIngredients().size());

        LayoutInflater inflater = LayoutInflater.from(this);
        for (Ingredient ingr : recipe.getIngredients()) {
            View view = inflater.inflate(R.layout.ingredient_item, ingrList, false);
            TextView labelView = view.findViewById(R.id.label);
            labelView.setText(ingr.text);
            ingrList.addView(view);
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(recipe.getUrl()));
        startActivity(i);
    }
}
