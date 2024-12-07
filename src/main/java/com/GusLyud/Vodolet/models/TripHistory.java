package com.GusLyud.Vodolet.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "triphistory")
public class TripHistory {

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

    @Column(name = "profit")
    private int profit;

    @ManyToOne
    @JoinColumn(name = "boat_id")
    private Boat boat;

    public TripHistory() {
    }

    public TripHistory(String roadMap, int cost, LocalDate dateOfVoyage, int quantity, int profit, Boat boat) {
        this.roadMap = roadMap;
        this.cost = cost;
        this.dateOfVoyage = dateOfVoyage;
        this.quantity = quantity;
        this.profit = profit;
        this.boat = boat;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getDateOfVoyage() {
        return dateOfVoyage;
    }

    public void setDateOfVoyage(LocalDate dateOfVoyage) {
        this.dateOfVoyage = dateOfVoyage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
