package com.example.RestAPI.repository;

import com.example.RestAPI.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepostiory extends JpaRepository<Location, Long> {
}
