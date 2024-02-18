package com.example.apimusica.AllJSON.Clases;

public class Artist {

    private String name;
    private String link;
    private String share;
    private String picture_medium;
    private int nb_fan;
    private String tracklist;

    public Artist(String name, String link, String share, String picture_medium, int nb_fan, String tracklist) {
        this.name = name;
        this.link = link;
        this.share = share;
        this.picture_medium = picture_medium;
        this.nb_fan = nb_fan;
        this.tracklist = tracklist;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getShare() {
        return share;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public int getNb_fan() {
        return nb_fan;
    }

    public String getTracklist() {
        return tracklist;
    }
}