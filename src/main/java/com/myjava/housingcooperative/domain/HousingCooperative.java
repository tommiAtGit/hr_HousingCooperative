package com.myjava.housingcooperative.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HousingCooperative {

	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 16, columnDefinition = "BINARY(16)", updatable = false, nullable = false)
	private UUID id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Address")
	private String address;
	@Column(name = "postnumber")
	private String postNumber;
	@Column(name = "City")
	private String city;
	@Column(name = "bankaccount")
	private String bankAccount;
}
