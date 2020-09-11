package com.myjava.housingrecord.web.controller;

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

import com.myjava.housingrecord.web.model.HousingCooperativeDto;
import com.myjava.housingrecord.web.service.CooperativeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/housingcooperative")
@RestController
public class HousingCooperativeController {

	private final CooperativeService cooperativeService;
	
	@GetMapping("/{cooperativeId}")
	public ResponseEntity<HousingCooperativeDto>getCooperativeById(@PathVariable("cooperativeId")UUID cooperativeId){
		
		return new ResponseEntity<HousingCooperativeDto>(cooperativeService.getById(cooperativeId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HousingCooperativeDto>saveHousingCooperative( @Validated @RequestBody HousingCooperativeDto hcDto){
		return new ResponseEntity<HousingCooperativeDto>(cooperativeService.saveNewHc(hcDto),HttpStatus.CREATED);
	}
	@PutMapping("/{cooperativeId}")
	public ResponseEntity<HousingCooperativeDto>updateHousingCooperative( @Validated @PathVariable("cooperativeId")UUID beerId, @Validated @RequestBody HousingCooperativeDto hcDto){
		return new ResponseEntity<HousingCooperativeDto>(cooperativeService.updateHC(beerId, hcDto),HttpStatus.NO_CONTENT);
	}
	
}
