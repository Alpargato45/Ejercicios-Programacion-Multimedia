package com.example.proyectotema5jorgedcm.Adaptador;

public class Datos {
    private int imagen;
    private String titulo;
    private String descripcion;
    private int audio;

    public Datos(int imagen, String titulo, String descripcion, int audio) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.audio = audio;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getAudio() {
        return audio;
    }
}
