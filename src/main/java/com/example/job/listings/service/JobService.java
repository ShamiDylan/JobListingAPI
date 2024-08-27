package com.example.job.listings.service;

import com.example.job.listings.model.Job;
import com.example.job.listings.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository JobRepository;

    public List<Job> getAllJobs() {
        return JobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return JobRepository.findById(id).orElse(null);
    }

    public Job saveJob(Job job) {

        return JobRepository.save(job);
    }
    public Job updateJob(Job job){
        Job foundJob= JobRepository.findById(job.getId()).orElseThrow(()-> new IllegalArgumentException("Job with id not found"));
        Job updatedJob=new Job();
        updatedJob.setTitle(job.getTitle()==null?foundJob.getTitle() :job.getTitle());
        updatedJob.setId(job.getId());
        updatedJob.setdescription(job.getDescription()==null ? foundJob.getDescription(): job.getDescription());
        updatedJob.setCompany(job.getCompany()==null ? foundJob.getCompany() : job.getCompany());
        updatedJob.setLocation(job.getLocation()==null? foundJob.getLocation(): job.getLocation());
        return JobRepository.save(updatedJob);
    }

    public void deleteJob(Long id) {
        JobRepository.deleteById(id);
//        JobRepository.flush();
//        JobRepository.deleteById(id);
    }
}
