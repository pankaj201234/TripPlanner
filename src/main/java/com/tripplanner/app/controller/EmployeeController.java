package com.tripplanner.app.controller;

import com.tripplanner.app.model.City;
import com.tripplanner.app.model.TopAttractions;
import com.tripplanner.app.repository.CityRepository;
import com.tripplanner.app.repository.EmployeeRepository;
import com.tripplanner.app.repository.TopAttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dev")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TopAttractionsRepository topAttractionsRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/TopAttractions")
    public List<TopAttractions> getAllTopAttraction(City city) {
        return city.getSpots();
    }

    @PostMapping("/AddCity")
    public void addCity(@Valid @RequestBody City city) {
        cityRepository.save(city);
    }

    @PostMapping("/AddTopAttraction")
    public void addCity(@Valid @RequestBody TopAttractions topAttraction) {
        //City city=topAttraction.getCity();
        topAttractionsRepository.save(topAttraction);
    }

    @PostMapping("/DeleteCity")
    public void deleteCity(@Valid @RequestBody City city) {
        //cityRepository.deleteById(city.getId());
        cityRepository.delete(city);
    }

    /*@PostMapping("/UpdateCityAttractions")
    public void updateCityAttractions(@Valid @RequestBody City city) {
    }*/
}