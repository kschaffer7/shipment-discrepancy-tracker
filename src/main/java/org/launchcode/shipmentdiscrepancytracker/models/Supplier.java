package org.launchcode.shipmentdiscrepancytracker.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier extends AbstractEntity{

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 1000, message = "Name must be between 1 and 1000 characters")
    private String name;

    @OneToMany(mappedBy = "supplier")
    private final List<Discrepancy> discrepancies = new ArrayList<>();

    public Supplier(@Size(min = 1, max = 1000, message = "Name must be between 1 and 1000 characters") String name) {
        this.name = name;
    }

    public Supplier () {}

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
