package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Upload extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent a = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(a);
                    break;
                case R.id.saved:
                    Intent b = new Intent(Upload.this,Saved.class);
                    startActivity(b);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.search:
                    Intent c = new Intent(Upload.this,Search.class);
                    startActivity(c);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.upload:
                    return true;
            }
            return false;
        });
    }
}