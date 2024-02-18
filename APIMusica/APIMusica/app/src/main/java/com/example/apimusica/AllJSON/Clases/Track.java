package com.example.apimusica.AllJSON.Clases;

import java.util.Date;

public class Track {

    private long id;
    private int duration;
    private Album album;
    private String title_short;
    private String release_date;
    private String link;
    private Artist artist;

    public long getId() {
        return id;
    }
    public int getDuration() {
        return duration;
    }

    public Album getAlbum() {
        return album;
    }

    public String getTitle_short() {
        return title_short;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getLink() {
        return link;
    }

    public Artist getArtist() {
        return artist;
    }
}