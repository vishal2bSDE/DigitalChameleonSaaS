package com.example.digitalchameleonsaas.repository;

import java.util.List;
import com.example.digitalchameleonsaas.dao.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("Select j from Job j where j.company.address.name = :addressName")
    List<Job> findAllByAddress(String addressName);

    @Query("Select j from Job j where j.company.address.city.name = :cityName")
    List<Job> findAllByCity(String cityName);
}
