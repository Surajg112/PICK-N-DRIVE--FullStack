package com.pickndrive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickndrive.daos.BookingRepository;
import com.pickndrive.daos.FeedbackRepository;
import com.pickndrive.daos.PaymentRepository;
import com.pickndrive.entities.Car;
import com.pickndrive.entities.Booking;
import com.pickndrive.entities.Customer;
import com.pickndrive.entities.Feedback;
import com.pickndrive.entities.Payment;
import com.pickndrive.entities.Variant;
import com.pickndrive.models.BookingCompleteDTO;
import com.pickndrive.models.BookingDTO;
import com.pickndrive.models.BookingStatusDTO;

@Service
public class BookingService {

	@Autowired private BookingRepository brepo;
	@Autowired private PaymentRepository prepo;
	@Autowired private CustomerService csrv;
	@Autowired private VariantService vsrv;
	@Autowired private CarService bksrv;
	@Autowired private FeedbackRepository frepo;
	
	public void saveBooking(BookingDTO dto) {
		System.out.println(dto);
		Customer customer=csrv.findByUserId(dto.getUserid());
		Variant variant=vsrv.findById(dto.getVarid());
		
		Booking bk=new Booking();
		BeanUtils.copyProperties(dto, bk);
		bk.setCustomer(customer);
		bk.setVariant(variant);
		System.out.println(bk);
		brepo.save(bk);
		
		Payment pmt=new Payment();
		BeanUtils.copyProperties(dto, pmt);
		pmt.setRemarks("Booking Amount");
		pmt.setBooking(bk);
		pmt.setAmount(dto.getAdvance());
		System.out.println(pmt);
		prepo.save(pmt);
		
	}
	
	public void updateBooking(BookingStatusDTO dto) {
		Booking bk=findById(dto.getBid());
		Car bik=bksrv.findById(dto.getBno());
		bk.setCar(bik);
		bk.setStatus("Confirmed");
		brepo.save(bk);
		
		bik.setStatus("Not Available");
		bksrv.updateCar(bik);
	}
	
	public void completeBooking(BookingCompleteDTO dto) {
		Booking bk=findById(dto.getBid());
		
		Car car=bk.getCar();
		car.setStatus("Available");
		bksrv.updateCar(car);		
		
		Payment pmt=new Payment();
		pmt.setAmount(dto.getAmount());
		pmt.setBooking(bk);
		pmt.setNameoncard(dto.getNameoncard());
		pmt.setCardno(dto.getCardno());
		pmt.setRemarks("Payment completed");
		pmt.setIscompleted(true);
		prepo.save(pmt);
		
		Feedback fb=new Feedback();
		fb.setCustomer(bk.getCustomer());
		fb.setDescr(dto.getFeedback());
		fb.setRatings(dto.getRatings());
		
		frepo.save(fb);
	}
	
	public List<Feedback> allFeedbacks(){
		return frepo.findAll();
	}
	
	public void cancelBooking(int id) {
		List<Payment> pmts=prepo.findByBooking(brepo.getById(id));
		prepo.deleteAll(pmts);
		brepo.delete(brepo.getById(id));
	}
	
	public Booking findById(int id) {
		return brepo.getById(id);
	}
	
	public List<Booking> findAllBookings(){
		return brepo.findAll();
	}
	
	public List<Payment> findAllPayments(){
		return prepo.findAll();
	}
	
	public List<Booking> findUserBookings(String userid){
		return brepo.findByCustomer(csrv.findByUserId(userid));
	}
	
	public List<Payment> findBookingPayments(int id){
		return prepo.findByBooking(brepo.getById(id));
	}
}

/*
Stock entity=new Stock();
BeanUtils.copyProperties(dto, entity);		
return entity;
*/