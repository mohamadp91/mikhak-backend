package com.example.transportationbackend.excelReader.models;

import lombok.Data;

@Data
public class RoadInputModel {
    private String firstPoint;
    private String secondPoint;
    private String width;
    private String distanceEachLightPost;
    private String cablePass;
    private String lp_height;
    private String lp_power;
    private String lp_lightProductionType;
    private String lightPostOnRoadSides;

}
