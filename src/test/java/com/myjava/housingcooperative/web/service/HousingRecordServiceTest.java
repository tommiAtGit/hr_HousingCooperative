package com.myjava.housingcooperative.web.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myjava.housingcooperative.web.model.HousingCooperativeDto;

@SpringBootTest
class HousingRecordServiceTest {

	@Autowired
	CooperativeService service;
	
	@Test
	void SaveNewHCtest() {
		
		HousingCooperativeDto actualDto = service.saveNewHc(getValidCooperateiveDto());
		assertNotNull(actualDto);
		assertEquals(getValidCooperateiveDto().getName(), actualDto.getName());
		
		//Clear content
		try {
			service.deleteHc(actualDto);
		} catch (Exception e) {
			assertFalse(false);
		}
		
		
	}
	

	@Test
	void GetByIdTest() {
		UUID ExpectedId = UUID.fromString("3132332d-3132-332d-3435-360000000000");
		
		HousingCooperativeDto actualDto = service.getById(ExpectedId);
		assertNotNull(actualDto);
		
		assertEquals(ExpectedId, actualDto.getId());
		
		
	}
	@Test
	void GetByNameTest() {
		
		String expectedName = "As Oy Jyv�skyl�n M�ntylehto";
		HousingCooperativeDto actualDto  = service.getByName(expectedName);
		assertNotNull(actualDto);
		System.out.println("*** uuid: **** " + actualDto.getId().toString());
		
	}
	
	@Test
	void UpdateHcTest() {
		
		String expectedAddress = "Some Test Address 1";
		String expectedCity = "Expected city";
		HousingCooperativeDto actualDto = service.saveNewHc(getValidCooperateiveDto());
		assertNotNull(actualDto);
		assertEquals(getValidCooperateiveDto().getName(), actualDto.getName());
		
		actualDto.setAddress(expectedAddress);
		actualDto.setCity(expectedCity);
		
		HousingCooperativeDto updatedDto = service.updateHC(actualDto.getId(), actualDto);
		
		if (updatedDto == null) {
			assertFalse(false);
		}
		
		assertEquals(expectedAddress, updatedDto.getAddress());
		assertEquals(expectedCity, updatedDto.getCity());
		
		
		//Clear content
		try {
			service.deleteHc(updatedDto);
		} catch (Exception e) {
			assertFalse(false);
		}
	}
	
	
	private HousingCooperativeDto getValidCooperateiveDto() {
		
		return HousingCooperativeDto.builder()
				.id(UUID.randomUUID())
				.name("Some Cooperative")
				.address("Jokusentie 12")
				.postNumber("123212-34")
				.city("Bankok")
				.bankAccount("FI224765123422")
				.build();
	}
}
