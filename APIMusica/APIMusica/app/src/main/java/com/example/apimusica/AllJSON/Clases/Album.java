package com.example.apimusica.AllJSON.Clases;

import java.net.URL;

public class Album {
    String cover_medium;
    String cover_big;

    public Album(String cover_medium, String cover_big) {
        this.cover_medium = cover_medium;
        this.cover_big = cover_big;
    }

    public String getCover_medium() {
        return cover_medium;
    }

    public void setCover_medium(String cover_medium) {
        this.cover_medium = cover_medium;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }
}