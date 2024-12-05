package com.GusLyud.Vodolet.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @Column(name = "boat_name")
    private String boatName;

    @Column(name = "capcity")
    private int capcity;

    @Column(name = "road_map")
    private String roadMap;

    @Column(name = "date_of_voyage")
    private LocalDate dateOfVoyage;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "boat", cascade = CascadeType.ALL)
    private List<Staff> listOfStaff;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "boat", cascade = CascadeType.ALL)
    private List<Pasengers> listOfPassengers;

    public Boat() {
    }

    public Boat(Long id, String boatName, int capcity, String roadMap, LocalDate dateOfVoyage, List<Staff> listOfStaff, List<Pasengers> listOfPassengers) {
        this.id = id;
        this.boatName = boatName;
        this.capcity = capcity;
        this.roadMap = roadMap;
        this.dateOfVoyage = dateOfVoyage;
        this.listOfStaff = listOfStaff;
        this.listOfPassengers = listOfPassengers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public int getCapcity() {
        return capcity;
    }

    public void setCapcity(int capcity) {
        this.capcity = capcity;
    }

    public String getRoadMap() {
        return roadMap;
    }

    public void setRoadMap(String roadMap) {
        this.roadMap = roadMap;
    }

    public LocalDate getDateOfVoyage() {
        return dateOfVoyage;
    }

    public void setDateOfVoyage(LocalDate dateOfVoyage) {
        this.dateOfVoyage = dateOfVoyage;
    }

    public List<Staff> getListOfStaff() {
        return listOfStaff;
    }

    public void setListOfStaff(List<Staff> listOfStaff) {
        this.listOfStaff = listOfStaff;
    }

    public List<Pasengers> getListOfPassengers() {
        return listOfPassengers;
    }

    public void setListOfPassengers(List<Pasengers> listOfPassengers) {
        this.listOfPassengers = listOfPassengers;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", boatName='" + boatName + '\'' +
                ", capcity=" + capcity +
                ", roadMap='" + roadMap + '\'' +
                ", dateOfVoyage=" + dateOfVoyage +
                ", listOfStaff=" + listOfStaff +
                ", listOfPassengers=" + listOfPassengers +
                '}';
    }
}
