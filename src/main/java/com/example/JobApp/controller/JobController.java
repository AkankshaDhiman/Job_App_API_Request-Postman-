package com.example.JobApp.controller;

import com.example.JobApp.model.Job;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    // read all data
    @GetMapping("jobs")
    public List<Job> getAllJob(){
        return jobService.getAllJobs();
    }

    // read single data
    @GetMapping("job/{id}")
    public Job getJob(@PathVariable("id") Long id){
        return jobService.getJob(id);
    }

    // create
    @PostMapping("job")
    public void addJob(@RequestBody Job job){
        jobService.addJob(job);
    }

    // update
    @PutMapping("job")
    public Job updateJob(@RequestBody Job job){
        jobService.updateJob(job);
        return jobService.getJob(job.getId());
    }

    //delete
    @DeleteMapping("job/{id}")
    public void deleteJob(@RequestBody Job job){
        jobService.deleteJob(job.getId());
    }

}
