package com.example.jobapp.controller;

import com.example.jobapp.dto.ApplicationRequestDTO;
import com.example.jobapp.model.Application;
import com.example.jobapp.model.Job;
import com.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JobApplicationController {

    @Autowired
    private JobService jobService;

    @PostMapping("/jobs")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job savedJob = jobService.saveJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @PostMapping("/applications/apply")
    public ResponseEntity<?> applyToJob(@RequestBody ApplicationRequestDTO requestDto) {
        try {
            Application application = jobService.applyToJob(requestDto);
            return new ResponseEntity<>(application, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = jobService.getAllApplications();
        return ResponseEntity.ok(applications);
    }
}