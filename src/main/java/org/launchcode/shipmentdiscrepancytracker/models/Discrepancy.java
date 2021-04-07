package org.launchcode.shipmentdiscrepancytracker.models;

public class Discrepancy {

    private String receivingClerk;

    private String vendor;

    private String itemNumber;

    public String getReceivingClerk() {
        return receivingClerk;
    }

    public void setReceivingClerk(String receivingClerk) {
        this.receivingClerk = receivingClerk;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

}
