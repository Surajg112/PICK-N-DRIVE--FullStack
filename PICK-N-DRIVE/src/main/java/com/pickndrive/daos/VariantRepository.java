package com.pickndrive.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickndrive.entities.Company;
import com.pickndrive.entities.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {

	List<Variant> findByCompany(Company company);
}
