package com.example.digitalchameleonsaas.repository;

import com.example.digitalchameleonsaas.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
