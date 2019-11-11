package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button btnPopular;
    Button btnBestRated;
    Button btnMyFavorites;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopular = (Button) findViewById(R.id.list_popular);
        btnBestRated = (Button) findViewById(R.id.list_bestrated);
        btnMyFavorites = (Button) findViewById(R.id.list_myfavorites);
        imageView = (ImageView) findViewById(R.id.imageView);

        btnPopular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this,PopularActivity.class);
                startActivity(it);
            }
        });

        btnBestRated.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this,BestRatedActivity.class);
                startActivity(it);
            }
        });

        btnMyFavorites.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this,MyFavoritesActivity.class);
                startActivity(it);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(it);
            }
        });

    }
}
