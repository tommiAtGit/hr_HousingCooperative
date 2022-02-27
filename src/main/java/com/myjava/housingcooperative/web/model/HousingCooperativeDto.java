package com.myjava.housingcooperative.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HousingCooperativeDto {
	
	private UUID id;
	private String name;
	private String address;
	private String postNumber;
	private String city;
	private String bankAccount;
}
