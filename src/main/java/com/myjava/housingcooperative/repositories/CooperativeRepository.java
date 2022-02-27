package com.myjava.housingcooperative.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myjava.housingcooperative.domain.HousingCooperative;


@Repository
public interface CooperativeRepository extends CrudRepository<HousingCooperative, UUID> {

}
