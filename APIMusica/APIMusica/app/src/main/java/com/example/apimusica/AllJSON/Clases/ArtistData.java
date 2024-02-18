package com.example.apimusica.AllJSON.Clases;

import java.util.List;

public class ArtistData {
    private List<Artist> data;

    public ArtistData(List<Artist> data) {
        this.data = data;
    }

    public List<Artist> getData() {
        return data;
    }
}