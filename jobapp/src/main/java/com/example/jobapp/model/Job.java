package com.example.jobapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;
    private Double packageAmount;
    private String location;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("job")
    private List<Application> applications;

    public Job() {}

    public Job(String companyName, String role, Double packageAmount, String location) {
        this.companyName = companyName;
        this.role = role;
        this.packageAmount = packageAmount;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Double getPackageAmount() { return packageAmount; }
    public void setPackageAmount(Double packageAmount) { this.packageAmount = packageAmount; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Application> getApplications() { return applications; }
    public void setApplications(List<Application> applications) { this.applications = applications; }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", packageAmount=" + packageAmount +
                ", location='" + location + '\'' +
                ", applications=" + applications +
                '}';
    }
}