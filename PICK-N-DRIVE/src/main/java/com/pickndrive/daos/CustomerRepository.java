package com.pickndrive.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
