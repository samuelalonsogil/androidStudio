package com.example.ejercicio04;


import java.util.ArrayList;

public class Team {

    String name, country, city, year;
    int image;

    private static ArrayList<Team> teams = new ArrayList<>();

    public Team(String name, String country, String city, String year, int image) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.year = year;
        this.image = image;
    }


    public static void addTeams() {
        teams.add(new Team("Chelsea FC", "England", "London", "1905", R.drawable.chelsea_escudo));
        teams.add(new Team("FC Bayern Munich", "Germany", "Múnich", "1900", R.drawable.bayern_escudo));
        teams.add(new Team("FK Spartak", "Russia", "Moscow", "1922", R.drawable.spartak_escudo));
        teams.add(new Team("Atlético de Madrid", "Spain", "Madrid", "1903", R.drawable.atletico_escudo));

    }

    public static ArrayList<Team> getTeams() {
        return teams;
    }


    public int getImages(){

        if (this.name.equals("Chelsea FC") ) return R.drawable.chelsea_escudo;
        else if ( this.name.equals("FC Bayern Munich") ) return R.drawable.bayern_escudo;
        else if ( this.name.equals("FK Spartak") ) return R.drawable.spartak_escudo;
        else if ( this.name.equals("Atlético de Madrid") ) return R.drawable.atletico_escudo;

        return 0;
    }
}
