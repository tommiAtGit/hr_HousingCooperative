package com.myjava.housingrecord.web.service;

import java.util.UUID;

import com.myjava.housingrecord.web.model.HousingCooperativeDto;

public interface CooperativeService {

	HousingCooperativeDto getById(UUID cooperativeId);

	HousingCooperativeDto getByName(String cooperativeName);
	
	HousingCooperativeDto updateHC(UUID cooperativeId,HousingCooperativeDto hcDto);
	
	HousingCooperativeDto saveNewHc(HousingCooperativeDto hcDto);
	
	void deleteHc(HousingCooperativeDto hcDto);
	
	
	
	
	
	
	

	 


}
