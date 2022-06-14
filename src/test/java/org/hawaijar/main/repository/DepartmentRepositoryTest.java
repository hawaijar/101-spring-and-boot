package org.hawaijar.main.repository;

import org.hawaijar.main.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class DepartmentRepositoryTest {
	@Autowired
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.name("IT")
				.id("101")
				.code("20103")
				.build();
		departmentRepository.save(department);
	}

	@Test
	public void findOne_should_return_a_department() {
		Department department = departmentRepository.findOne("IT");
		assertEquals("IT", department.getName());
	}
}
