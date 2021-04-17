package org.launchcode.shipmentdiscrepancytracker.data;

import org.launchcode.shipmentdiscrepancytracker.models.ReceivingClerk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivingClerkRepository extends CrudRepository<ReceivingClerk, Integer> {
}
