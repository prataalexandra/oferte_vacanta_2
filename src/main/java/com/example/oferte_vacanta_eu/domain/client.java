package com.example.oferte_vacanta_eu.domain;

import java.util.Objects;

public class client extends Entity<Long> {
    private Long id;
    private String name;
    private Integer fidelityGrade;
    private Integer varsta;
    private hobbies hobby;

    public client(Long id, String name, Integer fidelityGrade, Integer varsta, hobbies hobby) {
        this.id = id;
        this.name = name;
        this.fidelityGrade = fidelityGrade;
        this.varsta = varsta;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFidelityGrade() {
        return fidelityGrade;
    }

    public void setFidelityGrade(Integer fidelityGrade) {
        this.fidelityGrade = fidelityGrade;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public hobbies getHobby() {
        return hobby;
    }

    public void setHobby(hobbies hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        client client = (client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(fidelityGrade, client.fidelityGrade) && Objects.equals(varsta, client.varsta) && hobby == client.hobby;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fidelityGrade, varsta, hobby);
    }
}
