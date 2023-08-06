package com.te.ems.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Gender {
	
	FEMALE("FEMALE"), MALE("MALE"), OTHER("OTHER");

	private final String genderType;
}
