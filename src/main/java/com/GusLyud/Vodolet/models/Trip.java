package com.GusLyud.Vodolet.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "road_map")
    private String roadMap;

    @Column(name = "cost")
    private int cost;

    @Column(name = "date_of_voyage")
    private LocalDate dateOfVoyage;

    @Column(name = "quantity_passengers")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "boat_id")
    private Boat boat;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Passengers> listOfPassengers;

    public Trip() {
    }

    public Trip(String roadMap, int cost, LocalDate dateOfVoyage, Boat boat, List<Passengers> listOfPassengers) {
        this.roadMap = roadMap;
        this.cost = cost;
        this.dateOfVoyage = dateOfVoyage;
        this.boat = boat;
        this.listOfPassengers = listOfPassengers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public List<Passengers> getListOfPassengers() {
        return listOfPassengers;
    }

    public void setListOfPassengers(List<Passengers> listOfPassengers) {
        this.listOfPassengers = listOfPassengers;
    }
}
