package com.practicalddd.cargotracker.routingms.domain.model.valueobjects;


import com.practicalddd.cargotracker.routingms.domain.model.entities.CarrierMovement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

/**
 * A Voyage schedule
 */
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Schedule {

    public static final Schedule EMPTY = new Schedule();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "voyage_id")
    private List<CarrierMovement> carrierMovements = Collections.emptyList();

    public List<CarrierMovement> getCarrierMovements() {
        return Collections.unmodifiableList(carrierMovements);
    }
}
