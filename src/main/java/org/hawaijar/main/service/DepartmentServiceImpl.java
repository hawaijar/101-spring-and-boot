package org.hawaijar.main.service;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
}
