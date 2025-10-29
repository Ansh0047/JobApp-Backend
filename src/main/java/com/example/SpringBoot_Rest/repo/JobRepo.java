package com.example.SpringBoot_Rest.repo;

import com.example.SpringBoot_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This repo layers interacts with the database


// using the spring jpa, and in jpa we create and interface and that provide us with the crud features
@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    // in which filed we want to find just put the name of that column with prefix (findBy)
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}

// normal repository code using spring boot rest
//@Repository
//public class JobRepo {
//
//    // ArrayList to store JobPost objects
//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//                    List.of("HTML", "CSS", "JavaScript", "React")),
//            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                    List.of("Python", "Machine Learning", "Data Analysis")),
//            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                    List.of("Networking", "Cisco", "Routing", "Switching")),
//            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
//                    List.of("iOS Development", "Android Development", "Mobile App"))
//    ));
//
//    public List<JobPost> getAllJobs (){
//        return jobs;
//    }
//
//    public void addJob (JobPost job){
//        jobs.add(job);
//        System.out.println(jobs.getLast().getPostId());
//    }
//
//    public void deleteJob (int id){
//        for(JobPost j:jobs){
//            if(j.getPostId() == id)
//                jobs.remove(j);
//        }
//    }
//
//    public void updateJob (JobPost job){
//        for(JobPost j:jobs){
//            if(job.getPostId() == j.getPostId()){
//                j.setPostDesc(job.getPostDesc());
//                j.setPostProfile(job.getPostProfile());
//                j.setReqExperience(job.getReqExperience());
//                j.setPostTechStack(job.getPostTechStack());
//            }
//        }
//    }
//
//
//    public JobPost getJob(int id) {
//        for(JobPost job : jobs){
//            if(job.getPostId() == id) return job;
//        }
//
//        return null;
//    }
//}
