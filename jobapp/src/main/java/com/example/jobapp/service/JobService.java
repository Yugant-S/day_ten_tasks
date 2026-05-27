package com.example.jobapp.service;

import com.example.jobapp.dto.ApplicationRequestDTO;
import com.example.jobapp.model.Application;
import com.example.jobapp.model.Job;
import com.example.jobapp.repository.ApplicationRepository;
import com.example.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application applyToJob(ApplicationRequestDTO request) {
        boolean alreadyApplied = applicationRepository.existsByStudentIdAndJobId(request.getStudentId(), request.getJobId());
        if (alreadyApplied) {
            throw new RuntimeException("Student has already applied to this job.");
        }

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + request.getJobId()));

        Application application = new Application();
        application.setStudentId(request.getStudentId());
        application.setJob(job);
        application.setApplicationDate(LocalDate.now());
        application.setStatus("PENDING");

        return applicationRepository.save(application);
    }
}