package com.tripplanner.app.repository;

import com.tripplanner.app.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}