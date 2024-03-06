package com.example.oferte_vacanta_eu.domain;

public enum hoteltype {
    FAMILY("FAMILY"), TEENAGERS("TEENAGERS"), OLDPEOPLE("OLDPEOPLE");
    private final String text;
    hoteltype(String text){
        this.text=text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
