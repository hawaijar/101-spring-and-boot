package org.hawaijar.main.controller;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping( "/api/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
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
	@GetMapping("/api/departments/names/{name}")
	public Optional<Department> getDepartmentByName(@PathVariable("name") String name) {
		return departmentService.getDepartmentByName(name);
	}
	@DeleteMapping("/api/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id) {
		departmentService.deleteDepartmentById(id);
		return "Department with id:" + id + " deleted successfully";
	}
	@PutMapping("/api/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department) {
		return departmentService.updateDepartmentById(id, department);
	}
}
