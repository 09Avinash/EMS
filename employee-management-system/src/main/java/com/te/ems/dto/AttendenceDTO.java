package com.te.ems.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AttendenceDTO {
	private LocalDate date;
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	
	private EmployeeDTO employee;
}
