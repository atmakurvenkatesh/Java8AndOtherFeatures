package com.country.countriesInfo.models;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class ApiResponse {

	private Name name;

	private String cca2;

	private String ccn3;

	private String cca3;

	private String cioc;

}
