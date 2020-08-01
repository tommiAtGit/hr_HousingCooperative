package com.myjava.housingrecord.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.myjava.housingrecord.domain.HousingCooperative;
import com.myjava.housingrecord.repositories.CooperativeRepository;
import com.myjava.housingrecord.web.mappers.CooperativeMapper;
import com.myjava.housingrecord.web.model.HousingCooperativeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CooperativeServiceImpl implements CooperativeService {

	private final CooperativeRepository repository;
	private final CooperativeMapper mapper;
	
	public HousingCooperativeDto getById(UUID cooperativeId) {
		
		return mapper.HousingCooperativeToDto(
				repository.findById(cooperativeId).orElseThrow());
	}

	@Override
	public HousingCooperativeDto getByName(String cooperativeName) {
		
		return null;
	}

	@Override
	public HousingCooperativeDto updateHC(UUID cooperativeId, HousingCooperativeDto hcDto) {
		HousingCooperative hc = repository.findById(cooperativeId).orElseThrow();
		hc.setAddress(hcDto.getAddress());
		hc.setBankAccount(hcDto.getBankAccount());
		hc.setCity(hcDto.getCity());
		hc.setName(hcDto.getName());
		hc.setPostNumber(hcDto.getPostNumber());
		
		return mapper.HousingCooperativeToDto(repository.save(hc));
	}

	@Override
	public HousingCooperativeDto saveNewHc(HousingCooperativeDto hcDto) {
		
		return mapper.HousingCooperativeToDto(
				repository.save(mapper.DtoToHousingCooperative(hcDto)));
	}

}
