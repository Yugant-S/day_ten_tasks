package com.example.jobapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate applicationDate;
    private String status;

    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @JsonIgnoreProperties("applications")
    private Job job;

    public Application() {}

    public Application(LocalDate applicationDate, String status, Long studentId, Job job) {
        this.applicationDate = applicationDate;
        this.status = status;
        this.studentId = studentId;
        this.job = job;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getApplicationDate() { return applicationDate; }
    public void setApplicationDate(LocalDate applicationDate) { this.applicationDate = applicationDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                ", studentId=" + studentId +
                ", job=" + job +
                '}';
    }
}
