package com.example.catalogodefilmes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class PopularActivity extends AppCompatActivity {

    ArrayList<APIMovies> popular = new ArrayList<APIMovies>();

    ListView listView;
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        setTitle(R.string.list_popular);


    }

    public class MyAsyncTask extends AsyncTask<String, Integer, Integer> {
        public ArrayList<APIMovies> lista = new ArrayList<APIMovies>();
        @Override
        protected Integer doInBackground(String... strings) {

            MOVService service = new MOVService(getApplicationContext());
            lista = service.getPopularMovies();
            return 0;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            popular = lista;
            if(popular == null || popular.size() == 0) {
                adapter.setMovies(new ArrayList<APIMovies>());
            } else {
                adapter.setMovies(popular);
            }
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        MyAsyncTask task = new MyAsyncTask();
        task.execute("");

    }

}
