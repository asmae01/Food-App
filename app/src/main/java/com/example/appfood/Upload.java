package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Upload extends AppCompatActivity {


    String part_image;
    ImageButton uploadBtn;
    ImageView IVPreviewImage;
    int SELECT_PICTURE = 200;

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



        uploadBtn = findViewById(R.id.uploadButton);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);


        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
    }


    void imageChooser (){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }

    }

    public void submit(View view) {
        Intent i = new Intent(this, Search.class);
        startActivity(i);
    }
}