package com.pickndrive.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Customer;
import com.pickndrive.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	List<Feedback> findByCustomer(Customer customer);
}
