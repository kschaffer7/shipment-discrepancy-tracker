package org.launchcode.shipmentdiscrepancytracker.data;

import org.launchcode.shipmentdiscrepancytracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface DiscrepancyRepository extends CrudRepository<User, Integer> {
}
