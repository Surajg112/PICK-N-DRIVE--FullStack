package com.pickndrive.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Booking;
import com.pickndrive.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	List<Payment> findByBooking(Booking booking);

}
