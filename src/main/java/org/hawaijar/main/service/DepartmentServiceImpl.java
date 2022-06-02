package org.hawaijar.main.service;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department  updateDepartmentById(Long id, Department newDepartment) {
		Department department = departmentRepository.findById(id).orElse(null);
		if(department != null) {
			if(Objects.nonNull(newDepartment.getName()) &&
					!"".equalsIgnoreCase(newDepartment.getName())) {
				department.setName(newDepartment.getName());
			}
			if(Objects.nonNull(newDepartment.getCode()) &&
					!"".equalsIgnoreCase(newDepartment.getCode())) {
				department.setCode(newDepartment.getCode());
			}
			departmentRepository.save(department);
		}
		return department;
	}

	@Override
	public Optional<Department> getDepartmentByName(String name) {
		List<Department> listOfDepartment = departmentRepository.findAll();
		for(var d: listOfDepartment) {
			if(name.equalsIgnoreCase(d.getName())) {
				return Optional.of(d);
			}
		}
		return Optional.empty();
	}
}
