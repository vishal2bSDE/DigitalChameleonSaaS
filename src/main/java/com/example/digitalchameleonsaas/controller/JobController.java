package com.example.digitalchameleonsaas.controller;

import java.util.List;
import com.example.digitalchameleonsaas.dao.Job;
import com.example.digitalchameleonsaas.service.JobService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/addJob/{company}")
    public ResponseEntity<Job> addJob(
                                   @PathVariable String company,
                                   @RequestParam String jobTitle,
                                   @RequestParam int openings) throws NotFoundException {
        return ResponseEntity.ok(jobService.addJob(company, jobTitle, openings));
    }

    @GetMapping("/getAllJob")
    public ResponseEntity<List<Job>> getAllJobsDependingOnLocation(@RequestParam String city) {
        return ResponseEntity.ok(jobService.getAllJobByCity(city));
    }
}
