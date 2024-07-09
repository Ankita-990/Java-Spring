package com.master.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.dto.JobDto;
import com.master.entity.Job;
import com.master.mapping.MapJobDto;
import com.master.repository.JobRepository;
import com.master.service.ServiceJob;

@Service
public class ServiceJobImpl implements ServiceJob
{
	
	@Autowired
	JobRepository jobDao;

	@Autowired
	MapJobDto jobDto;
	
	@Override
	public JobDto addNewJob(JobDto dto) {
		Job job = jobDto.dtoToJob(dto);
		jobDao.save(job);
		return jobDto.jobToDto(job);
	}

	@Override
	public List<JobDto> fetchAllJobs() {
		List<Job> list = jobDao.findAll();
		List<JobDto> jobList = list.stream()
									.map(job -> jobDto.jobToDto(job))
									.collect(Collectors.toList());
		return jobList;
	}

	@Override
	public JobDto fetchJobById(int jobId) {
		Optional<Job> findJob = jobDao.findById(jobId);
		Job job = findJob.get();
		return jobDto.jobToDto(job);
	}

	@Override
	public JobDto updateJob(int jobId, JobDto dto) {
		Optional<Job> findJob = jobDao.findById(jobId);
		Job job = findJob.get();
		Job updateJob = Job.builder()
							.jobId(job.getJobId())
							.jobName(dto.getJobName())
							.jobDesc(dto.getJobDesc())
							.build();
		jobDao.save(updateJob);
		return jobDto.jobToDto(updateJob);
	}

	@Override
	public void deleteJob(int jobId) {
		jobDao.deleteById(jobId);
	}
	
	

}
