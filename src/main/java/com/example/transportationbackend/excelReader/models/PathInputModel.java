package com.example.transportationbackend.excelReader.models;

import lombok.Data;

import java.util.List;

@Data
public class PathInputModel {
    private String firstPoint;
    private String secondPoint;
    private String width;
    private String distanceEachLightPost;
    private String cablePass;
    private String lightPostOnPathSides;
    private List<LightPostInput> lightPostList;
}
