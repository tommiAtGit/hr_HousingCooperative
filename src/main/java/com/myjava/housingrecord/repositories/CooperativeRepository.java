package com.myjava.housingrecord.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myjava.housingrecord.domain.HousingCooperative;

public interface CooperativeRepository extends PagingAndSortingRepository<HousingCooperative, UUID>  {

}
