package com.tripplanner.app.controller;

import com.tripplanner.app.model.City;
import com.tripplanner.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public void getAllCities() {
//        return cityRepository.findAll();
    }

    @GetMapping("/TopAttractions")
    public void getAllTopAttraction() {

    }

    @PostMapping("/cities")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }
    public void deleteCity(){
    }
    public void updateCity(){
    }
}
