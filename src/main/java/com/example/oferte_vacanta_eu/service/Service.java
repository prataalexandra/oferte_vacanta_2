package com.example.oferte_vacanta_eu.service;
import com.example.oferte_vacanta_eu.domain.*;
import com.example.oferte_vacanta_eu.repo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private repoLocation locationRepo;
    private repoHotel hotelRepo;
    private repoOff offRepo;
    private repoClient clientRepo;
    private repoRezervare rezervareRepo;

    public Service(repoLocation locationRepo, repoHotel hotelRepo, repoOff offRepo, repoClient clientRepo,repoRezervare rezervareRepo) {
        this.locationRepo = locationRepo;
        this.hotelRepo = hotelRepo;
        this.offRepo = offRepo;
        this.clientRepo=clientRepo;
        this.rezervareRepo=rezervareRepo;
    }

    public List<location> getLocations() {
        return locationRepo.getAll();
    }

    public List<hotel> getHotels() {
        return hotelRepo.getAll();
    }
    public List<offers> getOffers() {
        return offRepo.getAll();
    }
    public List<client> getClients() {
        return clientRepo.getAll();
    }

    public Double getLocationId(String location) {
        for(location loc: locationRepo.getAll()){
            if(loc.getName().equals(location))
                return loc.getId();
        }
        return 0.0;
    }

    public client getClientById(Long idClient){
        for(client c: clientRepo.getAll())
            if(c.getId().equals(idClient))
                return c;
        return null;
    }

    public List<offers> getOffersAvailable(Long idClient){
        List<offers> all=new ArrayList<>();
        client client=getClientById(idClient);
        for(offers off: offRepo.getAll())
        {
            if(off.getEnd().compareTo(LocalDate.now())>0 && client.getFidelityGrade()>=off.getPercent())
                all.add(off);
        }
        return all;
    }

    public void adaugaRezervare(Long idClient,Double idHotel,LocalDate dataStart,Integer noNights){
        Double id;
        List<rezervare> rezv=new ArrayList<>();
        rezv=rezervareRepo.getAll();
        if(rezv.size()==0) id=1.0;
        else{
            id=rezv.get(rezv.size() - 1).getId()+1;
        }

        rezervare r=new rezervare(id,idClient,idHotel,dataStart,noNights);
        rezervareRepo.adauga(r);
    }
}

