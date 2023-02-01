package com.example.digitalchameleonsaas.service;

import java.util.List;
import com.example.digitalchameleonsaas.dao.Company;
import com.example.digitalchameleonsaas.dao.Job;
import com.example.digitalchameleonsaas.dao.User;
import com.example.digitalchameleonsaas.repository.JobRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;
    @Autowired
    CompanyService companyService;

    @Transactional
    public Job addJob(String companyName, String designation, int openings) throws NotFoundException {
        Company company = companyService.getCompanyByName(companyName);
        Job job = new Job();
        job.setCompany(company);
        job.setName(designation);
        job.setOpenings(openings);
        company.addJob(job);

        return jobRepository.save(job);
    }

    @Transactional
    public List<Job> getAllJobByAddress(User user) {
        return jobRepository.findAllByAddress(user.getAddress().getName());
    }

    @Transactional
    public List<Job> getAllJobByCity(String cityName) {
        return jobRepository.findAllByAddress(cityName);
    }
}
