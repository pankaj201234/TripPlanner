package com.tripplanner.app.controller;

import com.tripplanner.app.model.City;
import com.tripplanner.app.model.TopAttractions;
import com.tripplanner.app.repository.CityRepository;
import com.tripplanner.app.repository.TopAttractionsRepository;
import lombok.Getter;
//import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.List;
import java.lang.String;
import org.json.simple.parser.JSONParser;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TopAttractionsRepository topAttractionsRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/testLatitude")
    public Double getLatitude(String attractionName, String cityName) {
        final String uri = "https://us1.locationiq.com/v1/search.php?key=c36f432fd64ba5&q="+attractionName+","+cityName+"&format=json";
        RestTemplate restTemplate = new RestTemplate();
        String result1 = restTemplate.getForObject(uri, String.class);
        int latindex = result1.indexOf("lat");
        Double lat = Double.valueOf(result1.substring(latindex+6, latindex+15));
        return lat;
    }

    @GetMapping("/testLongitude")
    public Double getLongitude(String attractionName, String cityName) {
        final String uri = "https://us1.locationiq.com/v1/search.php?key=c36f432fd64ba5&q="+attractionName+","+cityName+"&format=json";
        RestTemplate restTemplate = new RestTemplate();
        String result1 = restTemplate.getForObject(uri, String.class);
        int longindex = result1.indexOf("lon");
        Double longi = Double.valueOf(result1.substring(longindex+6, longindex+15));
        return longi;
    }

    @GetMapping("/testAttractionType")
    public String getAttractionType(String attractionName, String cityName) {
        final String uri = "https://us1.locationiq.com/v1/search.php?key=c36f432fd64ba5&q="+attractionName+","+cityName+"&format=json";
        RestTemplate restTemplate = new RestTemplate();
        String result1 = restTemplate.getForObject(uri, String.class);
        String typ="";
        int typeindex = result1.lastIndexOf("type");
        for (int i = typeindex+7; result1.charAt(i) != '"'; i++) {
            typ =typ + result1.charAt(i);
        }
        return typ;
    }

    @GetMapping("/PlanIt")
    public List<TopAttractions> getShortestPath(List<TopAttractions> topAttractionsList) {
        TSP tsp = new TSP();
        Double[][] cityGraph=null;
        for(TopAttractions topAttractions1: topAttractionsList) {
            for(TopAttractions topAttractions2: topAttractionsList) {
                Double latitude1 = getLatitude(topAttractions1.getName(), topAttractions1.getCity().getName());
                Double longitude1 = getLongitude(topAttractions1.getName(), topAttractions1.getCity().getName());
                Double latitude2 = getLatitude(topAttractions2.getName(), topAttractions2.getCity().getName());
                Double longitude2 = getLongitude(topAttractions2.getName(), topAttractions2.getCity().getName());

                Double crowFlyDistance=getCrowFlyDistance(latitude1, latitude2, longitude1, longitude2);
                cityGraph[Math.toIntExact(topAttractions1.getId())][Math.toIntExact(topAttractions2.getId())]=crowFlyDistance;
            }
        }
        return tsp.TSPUtil(cityGraph, topAttractionsList.size());
    }

    private Double getCrowFlyDistance(Double lat1, Double lat2, Double lon1, Double lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    @GetMapping("/TopAttractions")
    public List<TopAttractions> getAllTopAttraction(City city) {
        return city.getSpots();
    }

    @PostMapping("/AddCity")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }
}