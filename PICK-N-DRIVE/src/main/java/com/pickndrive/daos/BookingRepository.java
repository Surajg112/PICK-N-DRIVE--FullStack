package com.pickndrive.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Booking;
import com.pickndrive.entities.Customer;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByCustomer(Customer customer);
}
