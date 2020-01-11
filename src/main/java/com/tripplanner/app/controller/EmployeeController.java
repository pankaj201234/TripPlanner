package com.tripplanner.app.controller;

import com.tripplanner.app.model.City;
import com.tripplanner.app.repository.CityRepository;
import com.tripplanner.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dev")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/TopAttractions")
    public void getAllTopAttraction(City city) {
        Long cc = city.getCityCode();

    }

    @PostMapping("/AddCity")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(@Valid @RequestBody City city) {
        cityRepository.deleteById(city.getId());
    }

    /*@PostMapping("/UpdateCityAttractions")
    public void updateCityAttractions(@Valid @RequestBody City city) {

    }*/
}