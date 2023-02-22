package com.pickndrive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickndrive.daos.CarRepository;
import com.pickndrive.entities.Car;
import com.pickndrive.models.CarDTO;

@Service
public class CarService {

	@Autowired private CarRepository brepo;
	@Autowired private VariantService vsrv;
	
	public void saveCar(CarDTO dto) {
		Car bk=new Car();
		BeanUtils.copyProperties(dto, bk);
		bk.setVariant(vsrv.findById(dto.getVarid()));
		brepo.save(bk);
	}
	
	public void updateCar(Car bk) {
		brepo.save(bk);
	}
	
	public List<Car> listAll(){
		return brepo.findAll();
	}
	
	public Car findById(String id) {
		return brepo.getById(id);
	}
	
	public List<Car> filterCar(int id){
		System.out.println("Filter id "+id);
		if(id==1)
			return brepo.findByStatus("Available");
		else
			return brepo.findByStatus("Not Available");
	}
	
	public List<Car> listVariantCar(int varid){
		return brepo.findByVariantAndStatus(vsrv.findById(varid),"Available");
	}
	
	public void deleteCar(String id) {
		if(brepo.existsById(id)) {
			brepo.delete(brepo.getById(id));
		}
	}	
}
