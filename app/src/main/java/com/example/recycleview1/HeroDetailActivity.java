package com.example.recycleview1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HeroDetailActivity extends AppCompatActivity {

    private Hero hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail);

        hero = getIntent().getParcelableExtra("HERO");

        if (hero != null) {
            setHeroDetail();
        }

        FloatingActionButton backButton = findViewById(R.id.backButtonDetail);
        backButton.setOnClickListener(view -> {
            finish();
        });
    }

    private void setHeroDetail() {
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDesc = findViewById(R.id.tvDetailDescription);
        ImageView ivHero = findViewById(R.id.ivDetailHero);

        tvName.setText(hero.getName());
        tvDesc.setText(hero.getDescription());
        ivHero.setImageResource(hero.getImage());

        tvDesc.setMovementMethod(new ScrollingMovementMethod());
    }
}
