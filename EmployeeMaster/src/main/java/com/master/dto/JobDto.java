package com.master.dto;

import com.master.entity.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class JobDto 
{
	private int jobId;
	private String JobName;
	private String jobDesc;
}
