package org.hawaijar.main.service;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.entity.Error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
	Department saveDepartment(Department department);

	List<Department> getAllDepartments();

	Optional<Department> getDepartmentById(String id) throws DepartmentNotFoundException;

	void deleteDepartmentById(String id);

	Department updateDepartmentById(String id, Department department);

	Optional<Department> getDepartmentByName(String name);
}
