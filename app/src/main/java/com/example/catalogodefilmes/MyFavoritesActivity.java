package com.example.catalogodefilmes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MyFavoritesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfavorites);
        setTitle(R.string.list_myfavorites);
    }
}
