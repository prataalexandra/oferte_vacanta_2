package com.example.oferte_vacanta_eu.domain;

import java.util.Objects;

public class location {
    private Double id;
    private String name;

    public location(double id,String name){
        this.id = id;
        this.name = name;
    }

    public Double getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        location location = (location) o;
        return Double.compare(id, location.id) == 0 && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
