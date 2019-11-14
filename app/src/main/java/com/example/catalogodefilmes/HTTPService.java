package com.example.catalogodefilmes;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HTTPService extends AsyncTask<Void,Void,APIMovies> {

    private final String apiEndpoint;
    private final Integer movieId;

    public HTTPService(String apiEndpoint, Integer movieId){
        this.apiEndpoint = apiEndpoint;
        this.movieId = movieId;
    }

    @Override
    protected APIMovies doInBackground(Void... voids){
        // https://api.themoviedb.org/3/movie/290859/similar?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1
        // https://api.themoviedb.org/3/movie/popular?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1
        // https://api.themoviedb.org/3/movie/top_rated?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/" + this.apiEndpoint + "?api_key=f88c7e268fd312246bacfb2cb4665cbb&language=pt-BR&page=1");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(60000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(),APIMovies.class);
    }
}
