package com.pickndrive.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Car;
import com.pickndrive.entities.Variant;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

	List<Car> findByVariantAndStatus(Variant variant,String status);
	List<Car> findByStatus(String status);
}
