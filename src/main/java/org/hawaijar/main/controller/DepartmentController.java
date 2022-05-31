package org.hawaijar.main.controller;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/api/departments")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	@GetMapping("/api/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	@GetMapping("/api/departments/{id}")
	public Optional<Department> getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}
}
