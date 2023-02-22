package com.pickndrive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickndrive.daos.CompanyRepository;
import com.pickndrive.entities.Company;

@Service
public class CompanyService {

	@Autowired private CompanyRepository repo;
	
	public void saveCompany(Company comp) {
		repo.save(comp);
	}
	
	public List<Company> listall(){
		return repo.findAll();
	}
	
	public void deleteCompany(int id) {
		repo.delete(repo.getById(id));
	}
	
	public Company findById(int id) {
		return repo.getById(id);
	}
}
