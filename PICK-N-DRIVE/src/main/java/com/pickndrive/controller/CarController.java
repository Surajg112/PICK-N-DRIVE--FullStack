package com.pickndrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickndrive.models.CarDTO;
import com.pickndrive.services.CarService;

@CrossOrigin
@RestController
@RequestMapping("/api/Car")
public class CarController {

	@Autowired private CarService bservice;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CarDTO dto) {		
		bservice.saveCar(dto);
		return ResponseEntity.ok("Saved successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(bservice.listAll());
	}
	
	@GetMapping("variants/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.listVariantCar(id));
	}
	
	@GetMapping("search")
	public ResponseEntity<?> findById(String id) {		
		return ResponseEntity.ok(bservice.findById(id));
	}
	
	@GetMapping("filter/{id}")
	public ResponseEntity<?> filterByStatus(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.filterCar(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		bservice.deleteCar(id);
		return ResponseEntity.ok("Car deleted successfully");
	}
}
