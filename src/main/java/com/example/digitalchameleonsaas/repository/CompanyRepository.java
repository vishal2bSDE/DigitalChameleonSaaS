package com.example.digitalchameleonsaas.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.Address;
import com.example.digitalchameleonsaas.dao.Company;
import com.example.digitalchameleonsaas.dao.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);

    List<Company> findAllAddress(Address address);
}
