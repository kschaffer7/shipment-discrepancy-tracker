package org.launchcode.shipmentdiscrepancytracker.data;

import org.launchcode.shipmentdiscrepancytracker.models.User;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
