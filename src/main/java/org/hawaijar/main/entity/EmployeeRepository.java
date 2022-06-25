package org.hawaijar.main.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findEmployeeByFirstName(String firstName);
}
