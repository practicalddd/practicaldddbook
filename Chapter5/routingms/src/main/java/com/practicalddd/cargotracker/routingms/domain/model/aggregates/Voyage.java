package com.practicalddd.cargotracker.routingms.domain.model.aggregates;


import com.practicalddd.cargotracker.routingms.domain.model.valueobjects.Schedule;
import com.practicalddd.cargotracker.routingms.domain.model.valueobjects.VoyageNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Entity
@NamedQueries({
        @NamedQuery(name = "Voyage.findByVoyageNumber", query = "Select v from Voyage v where v.voyageNumber = :voyageNumber"),
        @NamedQuery(name = "Voyage.findAll", query = "Select v from Voyage v order by v.voyageNumber")})
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @NotNull
    private Schedule schedule;

    @Embedded
    private VoyageNumber voyageNumber;

    public Voyage(VoyageNumber voyageNumber, Schedule schedule) {
        this.schedule = schedule;
        this.voyageNumber = voyageNumber;
    }

}
