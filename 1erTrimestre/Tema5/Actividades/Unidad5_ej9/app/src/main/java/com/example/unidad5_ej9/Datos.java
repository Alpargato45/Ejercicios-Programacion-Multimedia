package com.example.unidad5_ej9;

public class Datos {

    private int imagen;
    private boolean checkbox;
    private String texto;

    public Datos(int imagen, boolean checkbox, String texto) {
        this.imagen = imagen;
        this.checkbox = checkbox;
        this.texto = texto;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public int getImagen() {
        return imagen;
    }

    public boolean isSelected() {
        return checkbox;
    }

    public String getTexto() {
        return texto;
    }
}
