package org.launchcode.shipmentdiscrepancytracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity tells spring boot that this is a persistent object
@Entity
public class Discrepancy {

    //@Id declares primary key
    @Id
    @GeneratedValue
    private int id;

    private String discrepancy;

    public Discrepancy() {}

    public Discrepancy(int id, String discrepancy) {
        this.id = id;
        this.discrepancy = discrepancy;
    }

    public int getId() {
        return this.id;
    }

    public String getDiscrepancy() {
        return this.discrepancy;
    }

    public void setDiscrepancy(String discrepancy) {
        this.discrepancy = discrepancy;
    }
}
