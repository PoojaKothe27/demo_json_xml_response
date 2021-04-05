package com.multipleresponse.jsonxmlresponse.department.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multipleresponse.jsonxmlresponse.department.entity.Department;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{


}
