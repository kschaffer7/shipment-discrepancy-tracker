package org.launchcode.shipmentdiscrepancytracker.data;

import org.launchcode.shipmentdiscrepancytracker.models.Discrepancy;
import org.launchcode.shipmentdiscrepancytracker.models.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
}
