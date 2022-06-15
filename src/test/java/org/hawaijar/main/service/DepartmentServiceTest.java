package org.hawaijar.main.service;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {
	@Autowired
	private  DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.name("IT")
				.id(1L)
				.code("120L")
				.build();
		Mockito.when(departmentRepository.findByName("IT")).thenReturn(department);
	}
	@Test
	@DisplayName("Testing getDepartmentByName()")
	public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
		String departmentName = "IT";
		Optional<Department> found = departmentService.getDepartmentByName(departmentName);
		found.ifPresent(department -> assertEquals(departmentName, found.get().getName()));
	}
}
