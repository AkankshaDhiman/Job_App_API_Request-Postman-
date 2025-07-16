package com.example.JobApp.service;

import com.example.JobApp.dao.JobRepository;
import com.example.JobApp.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public Job getJob(Long id) {
        return (Job) repository.findById(id).orElse(new Job());
    }

    public void addJob(Job job) {
        repository.save(job);
    }

    public void updateJob(Job job) {
        repository.save(job);
    }

    public void deleteJob(Long id) {
        repository.deleteById(id);
    }
}
