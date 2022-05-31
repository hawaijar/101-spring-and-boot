package org.hawaijar.main.controller;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/api/departments")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
}
