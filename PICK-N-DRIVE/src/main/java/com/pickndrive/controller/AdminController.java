package com.pickndrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickndrive.entities.Admin;
import com.pickndrive.models.LoginDTO;
import com.pickndrive.models.Response;
import com.pickndrive.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired private AdminService adminService;
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Admin admin=adminService.validate(dto.getUserid(),dto.getPwd());
		if(admin!=null)
			return ResponseEntity.ok(admin);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> updateProfile(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
