package com.practicalddd.cargotracker.trackingms.domain.model.entities;


import com.practicalddd.cargotracker.trackingms.domain.model.valueobjects.TrackingEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class TrackingActivityEvent {

    public static final TrackingActivityEvent EMPTY_ACTIVITY = new TrackingActivityEvent();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_id")
    private List<TrackingEvent> trackingEvents = new ArrayList<TrackingEvent>();

}
