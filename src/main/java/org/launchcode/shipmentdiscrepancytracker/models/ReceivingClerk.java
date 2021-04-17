package org.launchcode.shipmentdiscrepancytracker.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ReceivingClerk extends AbstractEntity{

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "receivingClerk")
    private final List<Discrepancy> discrepancies = new ArrayList<>();

    public ReceivingClerk(@Size(min = 1, max = 100, message = "Name must be between 1 and 50 characters") String name) {
        this.name = name;
    }

    public ReceivingClerk () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discrepancy> getDiscrepancies() {
        return discrepancies;
    }

    @Override
    public String toString() {
        return name;
    }

}
