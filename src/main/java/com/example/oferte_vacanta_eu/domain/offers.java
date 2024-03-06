package com.example.oferte_vacanta_eu.domain;

import java.time.LocalDate;
import java.util.Objects;

public class offers {
    private Double id;
    private Double hotel;
    private LocalDate start;
    private LocalDate end;
    private Integer percent;

    public offers(Double id, Double hotel, LocalDate start, LocalDate end, Integer percent) {
        this.id = id;
        this.hotel = hotel;
        this.start = start;
        this.end = end;
        this.percent = percent;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getHotel() {
        return hotel;
    }

    public void setHotel(Double hotel) {
        this.hotel = hotel;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        offers offers = (offers) o;
        return Objects.equals(id, offers.id) && Objects.equals(hotel, offers.hotel) && Objects.equals(start, offers.start) && Objects.equals(end, offers.end) && Objects.equals(percent, offers.percent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotel, start, end, percent);
    }
}
