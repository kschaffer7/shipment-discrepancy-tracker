package org.launchcode.shipmentdiscrepancytracker.data;

import org.launchcode.shipmentdiscrepancytracker.models.Discrepancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscrepancyRepository extends CrudRepository<Discrepancy, Integer> {
}
