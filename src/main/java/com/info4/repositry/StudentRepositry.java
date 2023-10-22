package com.info4.repositry;

import com.info4.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositry extends JpaRepository<Student,Long> {
}
