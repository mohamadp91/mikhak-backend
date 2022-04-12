package com.example.transportationbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "light_post_tb")
public class LightPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "height")
    private Double height;

    @Column(name = "power")
    private Double power;

    @Column(name = "light_production_type")
    private String lightProductionType;

    @ManyToOne
    @JoinColumn(name = "pathId")
    @JsonIncludeProperties(value = "firstPoint")
    private PathEntity path;

    public LightPost(Double height,
                     Double power,
                     String lightProductionType,
                     PathEntity path) {

        this.height = height;
        this.power = power;
        this.lightProductionType = lightProductionType;
        this.path = path;
    }
}
