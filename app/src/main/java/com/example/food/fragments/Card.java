package com.example.food.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.food.R;
import com.example.food.models.RecipeModel;

public class Card extends Fragment {

    private final Context context;
    private final RecipeModel data;

    public Card(Context context, RecipeModel data) {
        super(R.layout.card);
        this.context = context;
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        view.setTag(data.getLabel());

        CardView cardView = view.findViewById(R.id.cardView);
        cardView.setOnClickListener((View.OnClickListener) context);

        ImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(context)
                .load(data.getImage())
                .placeholder(R.drawable.food_placeholder)
                .into(imageView);

        TextView titleView = view.findViewById(R.id.titleView);
        titleView.setText(data.getLabel());

        TextView calView = view.findViewById(R.id.calTextView);
        calView.setText(data.getCalories());

        return view;
    }
}
