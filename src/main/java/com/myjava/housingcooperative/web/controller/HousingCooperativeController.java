package com.myjava.housingcooperative.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myjava.housingcooperative.web.model.HousingCooperativeDto;
import com.myjava.housingcooperative.web.service.CooperativeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/housingcooperative")
@RestController
public class HousingCooperativeController {

	
	private final CooperativeService cooperativeService;
	@GetMapping("/")
	public ResponseEntity<List<HousingCooperativeDto>getAllCooperatives(){
		log.info("Get all Cooperatives called");
		return new ResponseEntity<List<HousingCooperativeDto>>(cooperativeService.getAll();
	}

	@GetMapping("/{cooperativeId}")
	public ResponseEntity<HousingCooperativeDto>getCooperativeById(@PathVariable("cooperativeId")UUID cooperativeId){
		log.info("Get Cooperative called with id: " + cooperativeId);
		
		return new ResponseEntity<HousingCooperativeDto>(cooperativeService.getById(cooperativeId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HousingCooperativeDto>saveHousingCooperative( @Validated @RequestBody HousingCooperativeDto hcDto){
		log.info("New cooperative added with name: " + hcDto.getName());
		return new ResponseEntity<HousingCooperativeDto>(cooperativeService.saveNewHc(hcDto),HttpStatus.CREATED);
	
	}
	@PutMapping("/{cooperativeId}")
	public ResponseEntity<HousingCooperativeDto>updateHousingCooperative( @Validated @PathVariable("cooperativeId")UUID cooperativeId, @Validated @RequestBody HousingCooperativeDto hcDto){
	
		log.info("Update Cooperative called with id: " + cooperativeId);
		
		return new ResponseEntity<HousingCooperativeDto>(cooperativeService.updateHC(cooperativeId, hcDto),HttpStatus.NO_CONTENT);
	}
	
}
