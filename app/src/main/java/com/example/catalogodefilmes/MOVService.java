package com.example.catalogodefilmes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MOVService {
    private SQLiteDatabase db;
    private DBCreate database;

    public MOVService(Context context){
        database = new DBCreate(context);
    }

    private String apiConnect(String method) throws Exception {
        try{
            String url = "https://api.themoviedb.org/3/movie/" + method + "?api_key=f88c7e268fd312246bacfb2cb4665cbb";
            OkHttpClient httpClient = new OkHttpClient();
            Request httpRequest = new Request.Builder().url(url).build();
            Response httpResponse = httpClient.newCall(httpRequest).execute();
            String apiJson = httpResponse.body().string();
            return apiJson;
        }catch (Exception e){
            throw e;
        }
    }

    public ArrayList<APIMovies> getPopularMovies(){
        ArrayList<APIMovies> movies = new ArrayList<>();
        try{
            String json = this.apiConnect("popular");
            JSONObject json_object = new JSONObject(json);
            JSONArray json_array = json_object.getJSONArray("results");
            int movie_quantity = json_array.length();
            for(int m = 0; m < movie_quantity; m++){
                JSONObject json_obj = json_array.getJSONObject(m);
                APIMovies movie = new APIMovies(
                        json_obj.getInt("id"),
                        json_obj.getString("title"),
                        json_obj.getString("poster_path"),
                        json_obj.getString("overview"),
                        json_obj.getDouble("popularity"),
                        json_obj.getDouble("vote_average")
                );
                movies.add(movie);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<APIMovies> getTopRatedMovies(){
        ArrayList<APIMovies> movies = new ArrayList<>();
        try{
            String json = this.apiConnect("top_rated");
            JSONObject json_object = new JSONObject(json);
            JSONArray json_array = json_object.getJSONArray("results");
            int movie_quantity = json_array.length();
            for(int m = 0; m < movie_quantity; m++){
                JSONObject json_obj = json_array.getJSONObject(m);
                APIMovies movie = new APIMovies(
                        json_obj.getInt("id"),
                        json_obj.getString("title"),
                        json_obj.getString("poster_path"),
                        json_obj.getString("overview"),
                        json_obj.getDouble("popularity"),
                        json_obj.getDouble("vote_average")
                );
                movies.add(movie);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return movies;
    }
}
