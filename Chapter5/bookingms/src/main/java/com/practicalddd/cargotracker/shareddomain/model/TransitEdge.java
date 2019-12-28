package com.practicalddd.cargotracker.shareddomain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents an edge in a path through a graph, describing the route of a
 * cargo.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TransitEdge implements Serializable {

    private String voyageNumber;
    private String fromUnLocode;
    private String toUnLocode;
    private Date fromDate;
    private Date toDate;

    @Override
    public String toString() {
        return "TransitEdge{"
                + "voyageNumber=" + voyageNumber
                + ", fromUnLocode=" + fromUnLocode
                + ", toUnLocode=" + toUnLocode
                + ", fromDate=" + fromDate
                + ", toDate=" + toDate + '}';
    }
}