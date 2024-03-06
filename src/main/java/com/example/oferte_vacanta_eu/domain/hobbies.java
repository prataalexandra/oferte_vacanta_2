package com.example.oferte_vacanta_eu.domain;

public enum hobbies {
    reading("reading"), music("music"), hiking("hiking"),walking("walking"),extrem_sports("extrem_sports");
    private final String text;
    hobbies(String text){
        this.text=text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
