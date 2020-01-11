package com.tripplanner.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "city")
@Entity
public class City {
    @Id
    @Getter
    @Setter
    private Long cityCode;

    @Getter
    @Setter
    private String name;



    //@Getter @Setter
    //private List<TopAttractions> spots;
}
