package com.example.transportationbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "road")
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_point")
    private double firstPoint;

    @Column(name = "second_point")
    private double secondPoint;

    @Column(name = "width")
    private float width;

    @Column(name = "distance_between_each_light_post")
    private int distanceEachLightPost;

    public long getId() {
        return id;
    }

    public double getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(double firstPoint) {
        this.firstPoint = firstPoint;
    }

    public double getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(double secondPoint) {
        this.secondPoint = secondPoint;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getDistanceEachLightPost() {
        return distanceEachLightPost;
    }

    public void setDistanceEachLightPost(int distanceEachLightPost) {
        this.distanceEachLightPost = distanceEachLightPost;
    }
}
