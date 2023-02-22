package com.pickndrive.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickndrive.daos.AdminRepository;
import com.pickndrive.entities.Admin;

@Service
public class AdminService {
	@Autowired AdminRepository dao;

	public Admin validate(String userid, String pwd) {
		// TODO Auto-generated method stub
		Optional<Admin> admin=dao.findById(userid);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}

	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(dao.getById(admin.getUserid()).getPwd());
		}
		dao.save(admin);		
	}

	public long countAdmin() {
		// TODO Auto-generated method stub
		return dao.count();
	}
}
