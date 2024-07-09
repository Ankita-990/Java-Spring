package com.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.master.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>
{

}
