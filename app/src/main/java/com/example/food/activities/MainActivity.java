package com.example.food.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.food.fragments.Card;
import com.example.food.models.IAmTokenModel;
import com.example.food.models.TranslateModel;
import com.example.food.services.EdamamService;
import com.example.food.R;
import com.example.food.models.Hit;
import com.example.food.models.RecipeModel;
import com.example.food.models.RecipeSearchModel;
import com.example.food.services.IAmTokenService;
import com.example.food.services.TranslateService;
import com.google.gson.Gson;
import com.victor.loading.rotate.RotateLoading;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<RecipeSearchModel> {

    private List<RecipeModel> recipes = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private EdamamService edamamService;
    private TranslateService translateService;

    private RotateLoading rotateLoading;
    private EditText search;
    private LinearLayout errorView;
    private TextView errorMessageView;

    @Override
    public void onResponse(Call<RecipeSearchModel> call, Response<RecipeSearchModel> response) {
        RecipeSearchModel recipeSearchModel = response.body();

        if (recipeSearchModel == null) {
            setError("Request limit exceeded");
            return;
        }
        if (recipeSearchModel.hits.size() == 0) {
            setError("Recipes not found");
            return;
        }

        for (Hit hit : recipeSearchModel.hits) {
            RecipeModel recipe = new RecipeModel(hit.recipe);
            recipes.add(recipe);
        }

        setOk();
        addFragments();
    }

    @Override
    public void onFailure(Call<RecipeSearchModel> call, Throwable t) {
        setError("No internet connection");
        t.printStackTrace();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        edamamService = EdamamService.getInstance();
        translateService = TranslateService.getInstance();

        IAmTokenService.getInstance().getToken().enqueue(new Callback<IAmTokenModel>() {
            @Override
            public void onResponse(Call<IAmTokenModel> call, Response<IAmTokenModel> response) {
                if (response.body() == null) return;
                translateService.setToken(response.body().iamToken);
            }

            @Override
            public void onFailure(Call<IAmTokenModel> call, Throwable t) {}
        });

        rotateLoading = findViewById(R.id.rotateloading);
        errorView = findViewById(R.id.errorView);
        errorMessageView = findViewById(R.id.errorMessageView);
        search = findViewById(R.id.search);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event == null || !event.isShiftPressed()) {
                        if (MainActivity.this.getCurrentFocus() != null) {
                            InputMethodManager inputManager =
                                    (InputMethodManager) MainActivity.this.
                                            getSystemService(Context.INPUT_METHOD_SERVICE);
                            inputManager.hideSoftInputFromWindow(
                                    MainActivity.this.getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                        }
                        doSearch();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CardPageActivity.class);

        for (RecipeModel recipe : recipes) {
            if (recipe.getLabel().equals(v.getTag())) {
                Gson gson = new Gson();
                intent.putExtra("recipe", gson.toJson(recipe));
                startActivity(intent);
                return;
            }
        }
    }

    private void addFragments() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (RecipeModel recipe : recipes) {
            Card card = new Card(this, recipe);
            ft.add(R.id.cardsContainer, card);
            fragments.add(card);
        }
        ft.commit();
    }

    private void removeAllFragments() {
        if (fragments.size() == 0) return;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : fragments) {
            ft.remove(fragment);
        }
        fragments.clear();
        ft.commit();
    }

    private void doSearch() {
        String searchValue = search.getText().toString();
        if (searchValue.isEmpty()) return;

        EdamamService.getInstance().getClient().dispatcher().cancelAll();
        removeAllFragments();
        recipes.clear();
        setLoading();

        translateService.translate(new String[]{searchValue}).enqueue(new Callback<TranslateModel>() {
            @Override
            public void onResponse(Call<TranslateModel> call, Response<TranslateModel> response) {
                String translatedText = searchValue;
                try {
                    translatedText = response.body().translations.get(0).text;
                } catch (NullPointerException e) {}

                edamamService.getRecipesByQ(translatedText).enqueue(MainActivity.this);
            }

            @Override
            public void onFailure(Call<TranslateModel> call, Throwable t) {
                setError(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void setOk() {
        rotateLoading.stop();
        errorView.setVisibility(View.GONE);
    }

    private void setLoading() {
        rotateLoading.start();
        errorView.setVisibility(View.GONE);
    }

    private void setError(String errorMessage) {
        rotateLoading.stop();
        ImageView loadingIcon = findViewById(R.id.loadingIcon);
        loadingIcon.setImageResource(R.drawable.ic_baseline_warning_24);
        errorView.setVisibility(View.VISIBLE);
        errorMessageView.setText(errorMessage);
    }
}
