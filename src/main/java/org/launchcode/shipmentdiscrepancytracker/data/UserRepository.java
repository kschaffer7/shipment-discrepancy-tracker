package org.launchcode.shipmentdiscrepancytracker.data;

import org.launchcode.shipmentdiscrepancytracker.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
