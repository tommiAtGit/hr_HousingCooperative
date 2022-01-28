package com.myjava.housingrecord.web.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myjava.housingrecord.web.model.HousingCooperativeDto;

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
