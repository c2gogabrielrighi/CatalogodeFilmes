package com.example.catalogodefilmes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BestRatedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestrated);
        setTitle(R.string.list_bestrated);
    }
}
