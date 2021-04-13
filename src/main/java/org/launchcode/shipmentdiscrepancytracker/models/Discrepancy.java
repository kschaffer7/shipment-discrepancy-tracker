package org.launchcode.shipmentdiscrepancytracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Entity tells spring boot that this is a persistent object
@Entity
public class Discrepancy extends AbstractEntity{

    @ManyToOne
    private Supplier supplier;

    @NotBlank(message = "Purchase order number is required")
    @Size(min = 1, max = 1000, message = "Purchase order number must be between 1 and 25 characters")
    private String purchaseOrder;

    @NotBlank(message = "Date is required")
    private String discrepancyDate;

    public String getDiscrepancyDate() {
        return discrepancyDate;
    }

    public void setDiscrepancyDate(String discrepancyDate) {
        this.discrepancyDate = discrepancyDate;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String name) {
        this.purchaseOrder = name;
    }

    @Override
    public String toString() {
        return purchaseOrder;
    }

    public Discrepancy() {}

    public Discrepancy(int id, String discrepancy) {
        super();
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
