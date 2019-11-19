package com.ecoresystems.greweekly.data.repository;

import com.ecoresystems.greweekly.data.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository <Users,Long> {
    Users findByMail(String mail);
}
