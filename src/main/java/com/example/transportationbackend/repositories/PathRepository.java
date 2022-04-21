package com.example.transportationbackend.repositories;

import com.example.transportationbackend.models.PathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends JpaRepository<PathEntity,Long> {
    boolean existsByPathId(Double id);
    PathEntity findByPathId(Double id);
}
