package com.example.apimusica.AllJSON;

import android.util.Log;

import com.example.apimusica.AllJSON.Clases.Artist;
import com.example.apimusica.AllJSON.Clases.Data;
import com.example.apimusica.AllJSON.Clases.ArtistData;
import com.example.apimusica.AllJSON.Clases.Track;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;

public class GestionJson {
    private String busqueda;

    public GestionJson(String busqueda) {
        this.busqueda = busqueda;
    }

    public String llamarApi(String urlApi) throws IOException {
        String apiUrl = urlApi + busqueda;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if (comprobarApi(connection)) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
        } else {
            return null;
        }
    }

    public boolean comprobarApi(HttpURLConnection connection) throws IOException {
        int codigoRespuesta = connection.getResponseCode();
        return codigoRespuesta == HttpURLConnection.HTTP_OK;
    }

    public String obtenertituloCancion(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Data response = gson.fromJson(apiResponse, Data.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Track cancion = response.getData().get(0);
                return cancion.getTitle_short();
            }
        }
        return null;
    }

    public long obtenerIdCancion(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Data response = gson.fromJson(apiResponse, Data.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Track cancion = response.getData().get(0);
                return cancion.getId();
            }
        }
        return 0;
    }

    public int obtenerduracionCancion(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Data response = gson.fromJson(apiResponse, Data.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Track cancion = response.getData().get(0);
                return cancion.getDuration();
            }
        }
        return 0;
    }

    public String obtenerFechaCancion(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Track response = gson.fromJson(apiResponse, Track.class);

            if (response != null && response.getRelease_date() != null && !response.getRelease_date().isEmpty()) {
                return response.getRelease_date();
            }
        }
        return null;
    }

    public String obtenerLinkCancion(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Data response = gson.fromJson(apiResponse, Data.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Track cancion = response.getData().get(0);
                return cancion.getLink();
            }
        }
        return null;
    }

    public String obtenercoverAlbum(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Data response = gson.fromJson(apiResponse, Data.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Track cancion = response.getData().get(0);
                return cancion.getAlbum().getCover_medium();
            }
        }
        return null;
    }

    public String obtenerNombreCantante(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Data response = gson.fromJson(apiResponse,Data.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Track cancion = response.getData().get(0);
                return cancion.getArtist().getName();
            }
        }
        return null;
    }

    public String obtenerNombreCantanteDesdeArtista(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            ArtistData response = gson.fromJson(apiResponse, ArtistData.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Artist artist = response.getData().get(0);
                return artist.getName();
            }
        }
        return null;
    }

    public String obtenerFotoArtista(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            ArtistData response = gson.fromJson(apiResponse, ArtistData.class);

            if (response != null && response.getData() != null && !response.getData().isEmpty()) {
                Artist artist = response.getData().get(0);
                return artist.getPicture_medium();
            }
        }
        return null;
    }
}