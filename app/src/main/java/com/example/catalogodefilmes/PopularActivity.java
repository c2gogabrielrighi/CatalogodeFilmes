package com.example.catalogodefilmes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PopularActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        setTitle(R.string.list_popular);
    }
}
