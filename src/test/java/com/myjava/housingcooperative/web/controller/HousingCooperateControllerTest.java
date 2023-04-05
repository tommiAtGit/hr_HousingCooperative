package com.myjava.housingcooperative.web.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myjava.housingcooperative.web.model.HousingCooperativeDto;
import com.myjava.housingcooperative.web.service.CooperativeService;

@WebMvcTest(HousingCooperativeController.class)
class HousingCooperateControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	CooperativeService cooperativeService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getAllCooperatives() throws Exception{
		given(cooperateService.getAll()).willReturn(getAllCooperativesDto());

		mockMvc.perform(get("/")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	void getCooperativeById() throws Exception{
		given(cooperativeService.getById(any())).willReturn(getValidCooperateiveDto());
		
							  
		mockMvc.perform(get("/api/housingcooperative/"+UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		
	}
	@Test
	void saveNewHousingCooperative()throws Exception{
		HousingCooperativeDto cooperativeDto = getValidCooperateiveDto();
		String cooperativeJson = objectMapper.writeValueAsString(cooperativeDto);
		
		given(cooperativeService.saveNewHc(any())).willReturn(getValidCooperateiveDto());
		
		mockMvc.perform(post("/api/housingcooperative")
				.contentType(MediaType.APPLICATION_JSON)
				.content(cooperativeJson))
				.andExpect(status().isCreated());
		
	}
	
	@Test
	void updateCooperateById() throws Exception {
		
		given(cooperativeService.updateHC(any(), any())).willReturn(getValidCooperateiveDto());
		
		HousingCooperativeDto cooperativeDto = getValidCooperateiveDto();
		String cooperativeJson = objectMapper.writeValueAsString(cooperativeDto);
		System.out.print(cooperativeJson);
		
		mockMvc.perform(put("/api/housingcooperative/"+UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(cooperativeJson))
				.andExpect(status().isNoContent());
		
		
	}
	
	private List<HousingCooperativeDto> getAllCooperativesDto(){
		List<HousingCooperativeDto> allDtos = new ArrayList();
		int i = 0;
		while(i< 10){
			allDtos.add(getValidCooperateiveDto());
			i++;
		}
		return allDtos;
	}
	private HousingCooperativeDto getValidCooperateiveDto() {
		
		return HousingCooperativeDto.builder()
				.id(UUID.randomUUID())
				.name("Some Cooperative")
				.address("Jokusentie 12")
				.postNumber("123212-34")
				.city("Bankok")
				.bankAccount("FI23220029933922")
				.build();
	}

}
