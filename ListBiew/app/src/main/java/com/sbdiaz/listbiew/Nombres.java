package com.sbdiaz.listbiew;

public class Nombres {
    private String name;
    private String capital;
    private int photo;

    public Nombres(String name, String capital, int photo) {
        this.name = name;
        this.capital = capital;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Nombres{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", photo=" + photo +
                '}';
    }
}