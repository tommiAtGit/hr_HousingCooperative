package com.myjava.housingcooperative.web.mappers;

import org.mapstruct.Mapper;

import com.myjava.housingcooperative.domain.HousingCooperative;
import com.myjava.housingcooperative.web.model.HousingCooperativeDto;

@Mapper(uses= {DateMapper.class})
public interface CooperativeMapper{

	HousingCooperativeDto HousingCooperativeToDto(HousingCooperative cooperative);
	
	HousingCooperative DtoToHousingCooperative(HousingCooperativeDto dto);
	
}
