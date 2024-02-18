package com.example.apimusica.AllJSON.Clases;

import java.util.List;

public class Data {

    private List<Track> data;

    public Data(List<Track> data) {
        this.data = data;
    }

    public List<Track> getData() {
        return data;
    }
}