package com.example.transportationbackend.models;

import com.example.transportationbackend.models.enums.CablePass;
import com.example.transportationbackend.models.enums.LightPostOnPathSides;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "paths_tb")
@Data
public class PathEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pathId;

    @Column(name = "first_point")
    private String firstPoint;

    @Column(name = "second_point")
    private String secondPoint;

    @Column(name = "width")
    private Double width;

    @Column(name = "distance_between_each_light_post")
    private Double distanceEachLightPost;

    @Column(name = "cable_pass")
    @Enumerated(EnumType.STRING)
    private CablePass cablePass;

    @Column(name = "light_post_on_sides_of_road")
    @Enumerated(EnumType.STRING)
    private LightPostOnPathSides lightPostOnPathSides;

    @OneToMany(mappedBy = "path")
    private List<LightPost> lightPosts;
}
