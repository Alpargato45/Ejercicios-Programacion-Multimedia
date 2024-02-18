package com.example.examentema7jorgedcm.AdaptadorPersonalizado;

public class Datos {
    private int clave;
    private String nombre;
    private int foto;
    private int lista;

    public Datos(int clave, String nombre, int foto, int lista) {
        this.clave = clave;
        this.nombre = nombre;
        this.foto = foto;
        this.lista = lista;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }
}