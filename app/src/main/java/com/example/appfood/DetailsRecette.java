package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailsRecette extends AppCompatActivity {
    ImageView imageRecettes;
    TextView name,type;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_recette);

        imageRecettes = findViewById(R.id.imgTopHome);
        name = findViewById(R.id.nameRecettes);
        type = findViewById(R.id.typeRecette);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String valeur1 = extras.getString("name");
            String valeur2 = extras.getString("type");
            int img = extras.getInt("image");

            imageRecettes.setImageResource(img);
            name.setText(valeur1);
            type.setText(valeur2);

        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent a = new Intent(DetailsRecette.this,MainActivity.class);
                    startActivity(a);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.saved:
                    Intent b = new Intent(DetailsRecette.this,Saved.class);
                    startActivity(b);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.search:
                    Intent d = new Intent(DetailsRecette.this,Search.class);
                    startActivity(d);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.upload:
                    Intent c = new Intent(DetailsRecette.this,Upload.class);
                    startActivity(c);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }
}