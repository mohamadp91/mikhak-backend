package com.example.transportationbackend.models;


import jakarta.persistence.*;

@Entity
@Table(name = "light_post")
public class LightPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "height")
    private int height;
    @Column(name = "power")
    private int power;
    @Column(name = "light_production_type")
    private String lightProductionType;
    @Column(name = "electrical_post_sides")
    private String electricalPostSides;

    public long getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getLightProductionType() {
        return lightProductionType;
    }

    public void setLightProductionType(String lightProductionType) {
        this.lightProductionType = lightProductionType;
    }

    public String getElectricalPostSides() {
        return electricalPostSides;
    }

    public void setElectricalPostSides(String electricalPostSides) {
        this.electricalPostSides = electricalPostSides;
    }
}
