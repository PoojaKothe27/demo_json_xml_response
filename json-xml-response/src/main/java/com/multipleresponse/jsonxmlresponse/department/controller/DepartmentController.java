package com.multipleresponse.jsonxmlresponse.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multipleresponse.jsonxmlresponse.department.entity.Department;
import com.multipleresponse.jsonxmlresponse.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	/**
	 * This API now can be accessed in two ways i.e.
	 * <br><b>Using Path Extension -</b> In the request we specify the required response type using the extension like .json,.xml or .txt. This has the highest preference
	 * <p> http://localhost:8080/departments/1.json
	 * <br> http://localhost:8080/departments/1.xml</p>
	 * 
	 * <br><b>Using url parameter -</b> In the request we specify the required response type using the url parameter like format=xml or format=json. This has the second highest preference
	 * <p> http://localhost:8080/departments/1?mediaType=json
	 * <br> http://localhost:8080/departments/1?mediaType=xml</p>
	 * 
	 * @param departmentId
	 * @return
	 */
	@GetMapping("{departmentId}")
	public Department findDepartmentById(@PathVariable Long departmentId) {
		log.info("Inside findDepartmentById of DepartmentController");
		return departmentService.findDepartmentById(departmentId);
	}
}