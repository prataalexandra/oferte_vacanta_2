package com.example.oferte_vacanta_eu.domain;

import java.time.LocalDate;
import java.util.Objects;

public class rezervare {
    private Double id;
    private Long idClient;
    private Double idHotel;
    private LocalDate dataStart;
    private Integer noNights;

    public rezervare(Double id, Long idClient, Double idHotel, LocalDate dataStart, Integer noNights) {
        this.id = id;
        this.idClient = idClient;
        this.idHotel = idHotel;
        this.dataStart = dataStart;
        this.noNights = noNights;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Double getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Double idHotel) {
        this.idHotel = idHotel;
    }

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public Integer getNoNights() {
        return noNights;
    }

    public void setNoNights(Integer noNights) {
        this.noNights = noNights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        rezervare rezervare = (rezervare) o;
        return Objects.equals(id, rezervare.id) && Objects.equals(idClient, rezervare.idClient) && Objects.equals(idHotel, rezervare.idHotel) && Objects.equals(dataStart, rezervare.dataStart) && Objects.equals(noNights, rezervare.noNights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, idHotel, dataStart, noNights);
    }
}
