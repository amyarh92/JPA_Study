package com.libqa.springboot.repository;

import com.libqa.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by coupang on 2015. 11. 4..
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findById(Long id);
}
