package com.tripplanner.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tripplanner.app.model.Auditable;
import com.tripplanner.app.model.City;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "Top_Attractions")
@JsonIgnoreProperties(value={"picURL"}, allowGetters= true)
public class TopAttractions extends Auditable{
    @Getter @Setter
    @ManyToOne(cascade = {CascadeType.ALL})
    private City city;

 //   @Getter @Setter
 //   private String typeOfAttraction;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int timeToCover;

 //   @Getter @Setter @URL
 //   private String picURL;
}