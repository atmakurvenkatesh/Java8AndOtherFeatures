package com.country.countriesInfo.models;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@Component
@ToString
public class Name {
	private String common;
	private String official;

}
