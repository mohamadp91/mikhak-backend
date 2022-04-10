package com.example.transportationbackend.models;

import com.example.transportationbackend.models.enums.CablePass;
import com.example.transportationbackend.models.enums.LightPostOnRoadSides;
import jakarta.persistence.*;


@Entity
@Table(name = "road")
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_point")
    private String firstPoint;

    @Column(name = "second_point")
    private String secondPoint;

    @Column(name = "width")
    private float width;

    @Column(name = "distance_between_each_light_post")
    private int distanceEachLightPost;

    @Column(name = "cable_pass")
    private CablePass cablePass;

    @Column(name = "light_post_on_sides_of_road")
    private LightPostOnRoadSides lightPostOnRoadSides;


    public long getId() {
        return id;
    }

    public CablePass getCablePass() {
        return cablePass;
    }

    public void setCablePass(CablePass cablePass) {
        this.cablePass = cablePass;
    }

    public LightPostOnRoadSides getLightPostOnRoadSides() {
        return lightPostOnRoadSides;
    }

    public void setLightPostOnRoadSides(LightPostOnRoadSides lightPostOnRoadSides) {
        this.lightPostOnRoadSides = lightPostOnRoadSides;
    }


    public String getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(String firstPoint) {
        this.firstPoint = firstPoint;
    }

    public String getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(String secondPoint) {
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
