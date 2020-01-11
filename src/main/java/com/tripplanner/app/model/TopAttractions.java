package com.tripplanner.app.model;

import com.tripplanner.app.model.Auditable;
import com.tripplanner.app.model.City;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "Top_Attractions")
public class TopAttractions extends Auditable {
    @ManyToOne
    @Getter
    @Setter
    private City city;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int timeToCover;

    @Getter @Setter @ElementCollection
    private Map<TopAttractions, Long> distanceToOtherAttractions;

    @Getter @Setter @URL
    private String picURL;
}