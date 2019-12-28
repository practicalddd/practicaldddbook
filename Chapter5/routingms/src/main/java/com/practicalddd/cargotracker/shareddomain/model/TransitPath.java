package com.practicalddd.cargotracker.shareddomain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class TransitPath implements Serializable {

    private List<TransitEdge> transitEdges;

    public TransitPath() {
        this.transitEdges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TransitPath{" + "transitEdges=" + transitEdges + '}';
    }
}
