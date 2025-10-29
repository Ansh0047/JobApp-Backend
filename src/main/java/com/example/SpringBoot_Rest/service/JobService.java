package com.example.SpringBoot_Rest.service;

import com.example.SpringBoot_Rest.model.JobPost;
import com.example.SpringBoot_Rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This service layer is for processing the data

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job){
        // repo.addJob(job);  // old way using spring boot rest
        repo.save(job);    // using the jpa
    }
    public void updateJob(JobPost job){
        // repo.updateJob(job);
        repo.save(job);
    }

    public List<JobPost> getAllJobs(){
        // return repo.getAllJobs();
        return repo.findAll();
    }

    public JobPost getJob(int id) {
        // return repo.getJob(id);
        return repo.findById(id).orElse(new JobPost());
    }

    public void deleteJob(int id) {
        // repo.deleteJob(id);
        repo.deleteById(id);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
