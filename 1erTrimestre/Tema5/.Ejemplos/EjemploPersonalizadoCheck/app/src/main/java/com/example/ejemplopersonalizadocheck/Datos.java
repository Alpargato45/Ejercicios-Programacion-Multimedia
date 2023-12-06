package com.example.ejemplopersonalizadocheck;

public class Datos {

    private String texto;

    private boolean check;

    public Datos(String texto, boolean check) {
        this.texto = texto;
        this.check = check;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
