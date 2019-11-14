package com.example.catalogodefilmes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

public class TopRatedActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestrated);
        setTitle(R.string.list_bestrated);

        gridView = findViewById(R.id.grid_bestrated);

        HTTPService service = new HTTPService("top_rated", null);
        try {
            APIMovies movies = service.execute().get();
            for (APIMovies movie:movies
                 ) {

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
