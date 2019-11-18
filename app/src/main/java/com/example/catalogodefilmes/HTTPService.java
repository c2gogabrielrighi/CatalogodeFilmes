package com.example.catalogodefilmes;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HTTPService extends AsyncTask<Void,Void,ArrayList<APIMovies>> {

    private final String apiEndpoint;
    private final Integer movieId;

    public HTTPService(String apiEndpoint, Integer movieId){
        this.apiEndpoint = apiEndpoint;
        this.movieId = movieId;
    }

    @Override
    protected ArrayList<APIMovies> doInBackground(Void... voids){
        // https://api.themoviedb.org/3/movie/290859/similar?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1
        // https://api.themoviedb.org/3/movie/popular?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1
        // https://api.themoviedb.org/3/movie/top_rated?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1
        ArrayList<APIMovies> lista = new ArrayList<>();
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/" + this.apiEndpoint + "?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(6000);
            connection.connect();

            if(connection.getResponseCode() != 200) {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {

                    APIMovies f = new Gson().fromJson(resposta.toString(), APIMovies.class);
                    //APIMovies f = new APIMovies();
                    lista.add(f);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return
        return lista;
    }
}
