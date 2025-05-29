package com.sreysor.school_management_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sreysor.school_management_api.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
