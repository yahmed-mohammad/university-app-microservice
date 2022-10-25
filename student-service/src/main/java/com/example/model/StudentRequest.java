package com.example.model;

import lombok.Data;

@Data
public class StudentRequest {
	private String firstName;
	private String lastName;
	private String email;
	private long addressId;

}
