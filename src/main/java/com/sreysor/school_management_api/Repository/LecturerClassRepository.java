package com.sreysor.school_management_api.Repository;

import com.sreysor.school_management_api.Entity.LecturerClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerClassRepository extends JpaRepository<LecturerClass, Long> {
}
