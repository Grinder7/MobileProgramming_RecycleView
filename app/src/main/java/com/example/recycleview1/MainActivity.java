package com.example.recycleview1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private final ArrayList<Hero> heroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setUpHeroes();

        // create adapter after setup models
        RecyclerView rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        rvHeroes.setAdapter(new HeroRecycleViewAdapter(this, heroes, this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setUpHeroes(){
        String[] heroNames = getResources().getStringArray(R.array.hero_names);
        String[] heroDescriptions = getResources().getStringArray(R.array.hero_descriptions);
        try(TypedArray heroImages = getResources().obtainTypedArray(R.array.hero_images)){
            for (int i = 0; i < heroNames.length; i++) {
                heroes.add(new Hero(heroNames[i], heroDescriptions[i], heroImages.getResourceId(i, 0)));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, HeroDetailActivity.class);
        intent.putExtra("HERO", heroes.get(position));
        Toast.makeText(this, "Kamu memilih: " + heroes.get(position).getName(), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}