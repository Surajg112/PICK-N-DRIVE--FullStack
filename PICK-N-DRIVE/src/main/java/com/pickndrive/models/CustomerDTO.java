package com.pickndrive.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CustomerDTO {
	
	@Email
	private String userid;
	@NotNull
	private String uname;
	@NotNull(message="Please provide password")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password!")
	private String pwd;
	@NotNull
	@Size(min = 10, max = 10)
	private String phone;
	@NotNull
	private String gender;
	@NotNull
	@Size(min = 2, max = 200)
	private String address;
	@NotNull
	@Size(min = 16, max = 16)
	private String license;
}
