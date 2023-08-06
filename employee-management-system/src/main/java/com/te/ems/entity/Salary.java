package com.te.ems.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Salary {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int salaryId;
	private double salaryAmount;
	private LocalDate startDate;
	private LocalDate endDate;
}
