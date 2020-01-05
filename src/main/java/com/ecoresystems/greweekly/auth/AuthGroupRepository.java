package com.ecoresystems.greweekly.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup,String> {
    List<AuthGroup> findByMail(String mail);
}
