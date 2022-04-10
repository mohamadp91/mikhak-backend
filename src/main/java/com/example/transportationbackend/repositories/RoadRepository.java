package com.example.transportationbackend.repositories;

import com.example.transportationbackend.models.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepository extends JpaRepository<Road,Long> {
}
