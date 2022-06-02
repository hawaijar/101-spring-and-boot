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
	public Optional<Department> getDepartmentById(@PathVariable("id") Long id) {
		return departmentService.getDepartmentById(id);
	}
	@DeleteMapping("/api/departments/{id}")
	public void deleteDepartmentById(@PathVariable("id") Long id) {
		departmentService.deleteDepartmentById(id);
	}
}
