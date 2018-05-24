package com.charlz.room.Threads;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.charlz.room.Adapter.MovieAdapter;
import com.charlz.room.Classes.AppDatabase;
import com.charlz.room.Classes.Movies;

import java.util.List;

/**
 * Created by UCA on 23/05/2018.
 */

public class Thread extends AsyncTask {

    private List<Movies> movies;
    private RecyclerView rv;
    private MovieAdapter adapter;
    private AppDatabase db;

    public Thread(List<Movies> movies, RecyclerView rv, MovieAdapter adapter, AppDatabase db){
        this.movies = movies;
        this.rv = rv;
        this.adapter = adapter;
        this.db = db;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        addMovie(movies);
        adapter = new MovieAdapter(movies);
        rv.setAdapter(adapter);
        return null;
    }

    public void addMovie(List<Movies> movies){
        movies.add(new Movies("Lucina","Waifu", "Fire Emblem"));
        movies.add(new Movies("Lucina2","Waifuer", "Fire Emblem"));
    }

}
