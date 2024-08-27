package com.example.job.listings.controller;

import com.example.job.listings.DTOs.JobDto;
import io.swagger.v3.oas.annotations.Operation;
import com.example.job.listings.model.Job;
import com.example.job.listings.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/jobs")
//@Api(value = "Job management system", tags = "Job API")
public class JobController {
    @Autowired
    private JobService jobService;
    @Operation(summary = "Get all job ")
    @GetMapping
//    @ApiOperation(value = "View a list of available jobs", response = List.class)
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();

    }


    @GetMapping("/{id}")
    @Operation(summary = "Get job by Id ")

    public JobDto getJobById(@PathVariable Long id) {
        Job foundJob= jobService.getJobById(id);
        JobDto foundJobDto= converttodto(foundJob);
        return foundJobDto;
    }

    @PostMapping
    @Operation(summary = "create new jobs")
    public JobDto createJob(@RequestBody JobDto jobdto) {
//        Random random= new Random();
//        long jobId= random.nextLong();
        Job job= convertToEntity(jobdto);
        Job savedJob=jobService.saveJob(job);
        return converttodto(savedJob) ;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a job by Id ")

    public JobDto updateJob(@PathVariable Long id, @RequestBody JobDto job) {
        Job receivedJob= new Job();
        receivedJob= convertToEntity(job);
        receivedJob.setId(id);
        Job updatedJob= jobService.updateJob(receivedJob);
        JobDto updatedJobDto= converttodto(updatedJob);
        return updatedJobDto;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Job By Id ")

    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }


    public JobDto converttodto(Job job){
        JobDto jobdto = new JobDto();
        jobdto.setTitle(job.getTitle());
        jobdto.setdescription(job.getDescription());
        jobdto.setCompany(job.getCompany());
        jobdto.setLocation(job.getLocation());
        return jobdto;

    }
    public Job convertToEntity(JobDto jobdto){
        Job job= new Job();
        job.setTitle(jobdto.getTitle());
        job.setCompany(jobdto.getCompany());
        job.setdescription(jobdto.getDescription());
        job.setLocation(jobdto.getLocation());
//        job.setId(id);
        return job;
    }

}
