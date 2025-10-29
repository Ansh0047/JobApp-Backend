package com.example.SpringBoot_Rest;

import com.example.SpringBoot_Rest.model.JobPost;
import com.example.SpringBoot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                     // when we are using the rest architecture we use rest controller
@CrossOrigin (origins = "http://localhost:3000")    // cross-origin to all the request from this url
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping ("/jobPosts")
//    @ResponseBody   this helps to  send the json data instead of jsp
    public List<JobPost> getAllJobs (){
        return service.getAllJobs();
    }

    // method to fetch the single record
    @GetMapping ("/jobPost/{id}")
    public JobPost getJob (@PathVariable int id){    // for using path params use PathVariable Annotation
        return service.getJob(id);
    }

    @GetMapping ("/jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword){
        return service.search(keyword);
    }

    // method to add job, and we will receive data in json format so we use @RequestBody to convert json to obj
    @PostMapping ("/jobPost")
    public String addJob (@RequestBody JobPost job){
        service.addJob(job);
        return "Job added successfully";
    }

    @PutMapping ("/jobPost")
    public String updateJob (@RequestBody JobPost job){
        service.updateJob(job);
        return "Job updated successfully";
    }

    @DeleteMapping ("/jobPost/{id}")
    public String deleteJob (@PathVariable int id){
        service.deleteJob(id);
        return "Job deleted successfully";
    }

    @GetMapping("/load")
    public String loadData(){
        service.load();
        return "success";
    }
}
