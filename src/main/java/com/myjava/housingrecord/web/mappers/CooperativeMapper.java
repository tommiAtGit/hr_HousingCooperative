package com.myjava.housingrecord.web.mappers;

import org.mapstruct.Mapper;

import com.myjava.housingrecord.domain.HousingCooperative;
import com.myjava.housingrecord.web.model.HousingCooperativeDto;

@Mapper(uses= {DateMapper.class})
public interface CooperativeMapper {

	HousingCooperativeDto HousingCooperativeToDto(HousingCooperative cooperative);
	
	HousingCooperative DtoToHousingCooperative(HousingCooperativeDto dto);
	
}
