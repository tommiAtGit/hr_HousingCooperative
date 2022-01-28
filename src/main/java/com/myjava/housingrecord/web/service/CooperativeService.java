package com.myjava.housingrecord.web.service;

import java.util.List;
import java.util.UUID;

import com.myjava.housingrecord.web.model.HousingCooperativeDto;

public interface CooperativeService {

	List<HousingCooperativeDto> getAll();
	
	HousingCooperativeDto getById(UUID cooperativeId);

	HousingCooperativeDto getByName(String cooperativeName);
	
	HousingCooperativeDto updateHC(UUID cooperativeId,HousingCooperativeDto hcDto);
	
	HousingCooperativeDto saveNewHc(HousingCooperativeDto hcDto);
	
	void deleteHc(HousingCooperativeDto hcDto);
	
	
	
	
	
	
	

	 


}
