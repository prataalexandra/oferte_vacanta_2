package com.example.oferte_vacanta_eu.domain;

import java.util.Objects;

public class hotel {
    private Double id;
    private Double lid;
    private String name;
    private Integer rooms;
    private Integer price;
    private hoteltype type;

    public hotel(Double id, Double lid, String name, Integer rooms, Integer price, hoteltype type) {
        this.id = id;
        this.lid = lid;
        this.name = name;
        this.rooms = rooms;
        this.price = price;
        this.type = type;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getLid() {
        return lid;
    }

    public void setLid(Double lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public hoteltype getType() {
        return type;
    }

    public void setType(hoteltype type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        hotel hotel = (hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(lid, hotel.lid) && Objects.equals(name, hotel.name) && Objects.equals(rooms, hotel.rooms) && Objects.equals(price, hotel.price) && type == hotel.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lid, name, rooms, price, type);
    }
}
