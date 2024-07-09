package com.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.dto.JobDto;
import com.master.service.ServiceJob;

@RestController
@RequestMapping("/project")
public class JobController 
{
	@Autowired
	ServiceJob serviceJob;
	
	@PostMapping("/job")
	public ResponseEntity<JobDto> addJob(@RequestBody JobDto dto) {
		JobDto job = serviceJob.addNewJob(dto);
		return new ResponseEntity<JobDto>(job, HttpStatus.OK);
	}
	
	@GetMapping("/job")
	public ResponseEntity<List<JobDto>> jobList() {
		List<JobDto> jobs = serviceJob.fetchAllJobs();
		return new ResponseEntity<List<JobDto>>(jobs, HttpStatus.OK);
	}
	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<JobDto> getJob(@PathVariable int jobId) {
		JobDto job = serviceJob.fetchJobById(jobId);
		return new ResponseEntity<JobDto>(job, HttpStatus.OK);
	}
	
	@PutMapping("/job/{jobId}")
	public ResponseEntity<JobDto> updateJob(@PathVariable int jobId, @RequestBody JobDto dto) {
		JobDto update = serviceJob.updateJob(jobId, dto);
		return new ResponseEntity<JobDto>(update, HttpStatus.OK);
	}
	
	@DeleteMapping("/job/{jobId}")
	public ResponseEntity<JobDto> removeJob(@PathVariable int jobId) {
		serviceJob.deleteJob(jobId);
		return new ResponseEntity<JobDto>(HttpStatus.OK);
	}
	
}
