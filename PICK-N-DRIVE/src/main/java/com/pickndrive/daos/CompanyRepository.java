package com.pickndrive.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
