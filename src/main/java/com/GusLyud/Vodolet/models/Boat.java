package com.GusLyud.Vodolet.models;

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

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "boat", cascade = CascadeType.ALL)
    private List<Staff> listOfStaff;

    public Boat() {
    }

    public Boat(String boatName, int capcity, String imageUrl, List<Staff> listOfStaff) {
        this.boatName = boatName;
        this.capcity = capcity;
        this.imageUrl = imageUrl;
        this.listOfStaff = listOfStaff;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public List<Staff> getListOfStaff() {
        return listOfStaff;
    }

    public void setListOfStaff(List<Staff> listOfStaff) {
        this.listOfStaff = listOfStaff;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", boatName='" + boatName + '\'' +
                ", capcity=" + capcity +
                ", listOfStaff=" + listOfStaff +
                '}';
    }
}
