package com.te.ems.dto;

import java.time.LocalDate;

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
@Builder
@ToString
public class ProjectDTO {

	private String projectName;
	private LocalDate projectStartDate;
	private LocalDate projectEndDate;
	private boolean isCompleted;

}
