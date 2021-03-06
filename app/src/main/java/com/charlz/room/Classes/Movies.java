package com.charlz.room.Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by UCA on 23/05/2018.
 */
@Entity(tableName = "movies")
public class Movies {

    @PrimaryKey(autoGenerate = true)
    private int idMovie;

    @ColumnInfo(name = "nom_movie")
    private String nomMovie;

    @ColumnInfo(name = "desc_movie")
    private String descMovie;

    @ColumnInfo(name = "nom_category")
    private String nomcategory;

    @ColumnInfo(name = "nom_studio")
    private String nomstudio;

    public Movies() {
    }

    public Movies(String nomMovie, String nomcategory, String nomstudio) {
        this.nomMovie = nomMovie;
        this.nomcategory = nomcategory;
        this.nomstudio = nomstudio;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getNomMovie() {
        return nomMovie;
    }

    public void setNomMovie(String nomMovie) {
        this.nomMovie = nomMovie;
    }

    public String getDescMovie() {
        return descMovie;
    }

    public void setDescMovie(String descMovie) {
        this.descMovie = descMovie;
    }

    public String getNomcategory() {
        return nomcategory;
    }

    public void setNomcategory(String nomcategory) {
        this.nomcategory = nomcategory;
    }

    public String getNomstudio() {
        return nomstudio;
    }

    public void setNomstudio(String nomstudio) {
        this.nomstudio = nomstudio;
    }
}
