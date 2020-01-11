package com.tripplanner.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Table(name = "city")
@Entity
public class City extends Auditable{

    @Getter
    @Setter
    private Long cityCode;

    @Getter
    @Setter
    private String name;


    @OneToMany(mappedBy = "city")
    @Getter @Setter
    private List<TopAttractions> spots;
}
