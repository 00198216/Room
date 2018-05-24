package com.charlz.room.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.charlz.room.Classes.Movies;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by UCA on 23/05/2018.
 */

@Dao
public interface MoviesDAO {

    @Query("SELECT * FROM MOVIES")
    List<Movies> getALL();

    @Insert(onConflict = REPLACE)
    void insertMovie(Movies movie);
}
