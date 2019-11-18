package com.example.catalogodefilmes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;

public class APIMovies implements Serializable {
    int id;
    String title;
    String poster_path;
    String overview;
    double popularity;
    double rate_average;

    public APIMovies(){}

    public APIMovies(int id, String title, String poster_path, String overview, double popularity, double rate_average){
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.popularity = popularity;
        this.rate_average = rate_average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getRate_average() {
        return rate_average;
    }

    public void setRate_average(double rate_average) {
        this.rate_average = rate_average;
    }

    @NonNull
    @Override
    public String toString() {
        return this.id + " " + this.title;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof APIMovies && ((APIMovies)obj).id == this.id;
    }
}
