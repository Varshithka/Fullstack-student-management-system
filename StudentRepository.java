package com.studentjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studentjpa.entity.student;

public interface StudentRepository extends JpaRepository<student, Long> {
}