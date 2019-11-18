package com.example.catalogodefilmes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private ArrayList<APIMovies> movies;
    private Activity activity;

    public GridAdapter(ArrayList<APIMovies> movies, Activity activity){
        this.movies = movies;
        this.activity = activity;
    }

    public void setMovies(ArrayList<APIMovies> itens) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return movies.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String basePath = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
        View v = activity.getLayoutInflater().inflate(R.layout.thumbnail_movie,viewGroup,false);
        final APIMovies m = movies.get(i);
        ImageView image_movie = (ImageView)v.findViewById(R.id.image_movie);
        Picasso.get().load(basePath + m.getPoster_path()).into(image_movie);
        return v;
    }
}
