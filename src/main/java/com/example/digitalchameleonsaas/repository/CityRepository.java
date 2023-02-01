package com.example.digitalchameleonsaas.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<Set<City>> findByName(String name);
}
