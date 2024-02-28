package com.example.examentema7parte2jorgedcm.AdaptadorLista;

public class Datos {

    private int indice;
    private String nombre;
    private String telefono;
    private int personaje;

    public Datos(int indice, String nombre, String telefono, int personaje){
        this.indice = indice;
        this.nombre = nombre;
        this.telefono = telefono;
        this.personaje = personaje;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPersonaje() {
        return personaje;
    }

    public void setPersonaje(int personaje) {
        this.personaje = personaje;
    }
}
