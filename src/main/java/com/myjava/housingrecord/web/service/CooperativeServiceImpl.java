package com.myjava.housingrecord.web.service;

import java.util.List;
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
		
		List<HousingCooperative> hCs = (List<HousingCooperative>) repository.findAll();
		
		if (hCs != null) {
			for (HousingCooperative housingCooperative : hCs) {
				if (housingCooperative.getName().equals(cooperativeName)) {
					return mapper.HousingCooperativeToDto(
							housingCooperative);
				}
			}
		}
			
		return null;
	}

	@Override
	public HousingCooperativeDto updateHC(UUID cooperativeId, HousingCooperativeDto hcDto) {
		if (cooperativeId.equals(null)) {
			return null;
		}
		HousingCooperative hc = repository.findById(cooperativeId).orElseThrow();
		hc.setAddress(hcDto.getAddress());
		hc.setCity(hcDto.getCity());
		hc.setName(hcDto.getName());
		hc.setPostNumber(hcDto.getPostNumber());
		hc.setBankAccount(hcDto.getBankAccount());
		
		return mapper.HousingCooperativeToDto(repository.save(hc));
	}

	@Override
	public HousingCooperativeDto saveNewHc(HousingCooperativeDto hcDto) {
		
		return mapper.HousingCooperativeToDto(
				repository.save(mapper.DtoToHousingCooperative(hcDto)));
	}

	@Override
	public void deleteHc(HousingCooperativeDto hcDto) {
		
		repository.delete(mapper.DtoToHousingCooperative(hcDto));
		
	}

}
