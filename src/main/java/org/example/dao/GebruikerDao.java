package org.example.dao;


import org.example.domain.Gebruiker;

import java.util.HashMap;

public enum GebruikerDao {
    INSTANCE;

    private HashMap<String, Gebruiker> persoons = new HashMap<>();

    public void add(Gebruiker gebruiker) {
        persoons.put(gebruiker.getEmail(), gebruiker);
    }

    public Gebruiker getPersoonByEmail(String email){
        return persoons.get(email);
    }


}
