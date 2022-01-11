package com.example.reciclerview02;

import android.graphics.drawable.Drawable;

public class Nombres {
    private String nombre;
    private String capital;
    private int bandera; //checkea cargar los recursos drawable

    public Nombres(String nombre, String capital, int bandera) {
        this.nombre = nombre;
        this.capital = capital;
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCapital() {
        return capital;
    }

    public int getBandera() {
        return bandera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
}
