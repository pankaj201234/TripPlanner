package com.tripplanner.app.repository;

import com.tripplanner.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {

}
