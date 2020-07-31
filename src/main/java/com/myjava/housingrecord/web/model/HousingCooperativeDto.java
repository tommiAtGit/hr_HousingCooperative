package com.myjava.housingrecord.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingCooperativeDto {
	
	private UUID id;
	private String name;
	private String address;
	private String postNumber;
	private String city;
	private String bankAccount;
}
