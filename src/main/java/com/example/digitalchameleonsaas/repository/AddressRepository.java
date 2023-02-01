package com.example.digitalchameleonsaas.repository;

import java.util.Optional;
import java.util.Set;
import com.example.digitalchameleonsaas.dao.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Set<Address>> findByName(String name);
}
