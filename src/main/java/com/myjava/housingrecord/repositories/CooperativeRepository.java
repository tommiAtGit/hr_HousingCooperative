package com.myjava.housingrecord.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myjava.housingrecord.domain.HousingCooperative;


@Repository
public interface CooperativeRepository extends CrudRepository<HousingCooperative, UUID> {

}
