package com.master.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.dto.JobDto;
import com.master.entity.Job;

@Component
public class MapJobDto {

	@Autowired
	ModelMapper modelMapper;
	
	// Job to Dto
		public JobDto jobToDto(Job job) {
			JobDto dto = this.modelMapper.map(job, JobDto.class);
			return dto;
		}
		
		// Dto to Job
		public Job dtoToJob(JobDto dto) {
			Job job = this.modelMapper.map(dto, Job.class);
			return job;
		}
	
}
