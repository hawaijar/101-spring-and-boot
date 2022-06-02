package org.hawaijar.main.service;

import org.hawaijar.main.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
	Department saveDepartment(Department department);

	List<Department> getAllDepartments();

	Optional<Department> getDepartmentById(Long id);

	void deleteDepartmentById(Long id);
}
