package org.hawaijar.main.repository;

import org.hawaijar.main.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager testEntityManager;
	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.name("IT")
				.id(10L)
				.code("20103")
				.build();
		testEntityManager.merge(department);
	}

	@Test
	public void findByName_should_return_a_department() {
		Department department = departmentRepository.findByName("IT");
		assertEquals("IT", department.getName());
	}
}
