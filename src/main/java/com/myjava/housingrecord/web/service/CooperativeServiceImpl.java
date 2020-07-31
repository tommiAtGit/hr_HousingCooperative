package com.myjava.housingrecord.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

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
		
		return mapper.HousingCooperativeToDto(repository.findById(cooperativeId).orElseThrow());
	}

	@Override
	public HousingCooperativeDto getByName(String cooperativeName) {
		
		return null;
	}

	@Override
	public HousingCooperativeDto updateHC(UUID cooperativeId, HousingCooperativeDto hcDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HousingCooperativeDto saveNewHc(HousingCooperativeDto hcDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
