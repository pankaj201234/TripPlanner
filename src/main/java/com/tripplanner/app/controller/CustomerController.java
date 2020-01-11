package com.tripplanner.app.controller;

import com.tripplanner.app.model.City;
import com.tripplanner.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    /*@GetMapping("/user/TopAttractions")
    public void getAllTopAttraction(City city) {
//        return city.getSpots();
    }*/

    @PostMapping("/AddCity")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }
}