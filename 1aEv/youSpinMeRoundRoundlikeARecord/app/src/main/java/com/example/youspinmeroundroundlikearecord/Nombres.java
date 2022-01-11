package com.example.youspinmeroundroundlikearecord;

public class Nombres {

    private String nombre;
    private String capital;
    private int bandera;

    public Nombres(String nombre, String capital, int bandera) {
        this.nombre = nombre;
        this.capital = capital;
        this.bandera = bandera;
    }

    public int getBandera() {
        return bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCapital(String capital) { this.capital = capital; }
}
