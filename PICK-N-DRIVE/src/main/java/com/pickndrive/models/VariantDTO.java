package com.pickndrive.models;

import org.springframework.web.multipart.MultipartFile;

public class VariantDTO {
	private String title;
	private int price;
	private int company_id;
	private MultipartFile photo;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "VariantDTO [title=" + title + ", price=" + price + ", company_id=" + company_id + ", photo=" + photo
				+ "]";
	}
	
	
}

