package com.example.digitalchameleonsaas.repository;

import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Set<Country>> findByName(String name);
}
