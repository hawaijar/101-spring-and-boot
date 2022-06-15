package org.hawaijar.main.controller;

import org.hawaijar.main.entity.Department;
import org.hawaijar.main.entity.Error.DepartmentNotFoundException;
import org.hawaijar.main.repository.DepartmentRepository;
import org.hawaijar.main.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	private Department department;

	@BeforeEach
	void setUp() {
		department = Department.builder()
				.name("IT")
				.id(1L)
				.code("120L")
				.build();
	}

	@Test
	void saveDepartment() throws Exception {
		Department inputDepartment = Department.builder()
				.name("IT")
				.code("120L")
				.build();
		Mockito.when(departmentService.saveDepartment(inputDepartment)).
				thenReturn(department);

		mockMvc.perform(post("/api/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"\t\"name\": \"IT\",\n" +
						"\t\"code\": \"120L\"\n" +
						"}"))
				.andExpect(status().isOk());
	}

	@Test
	void getDepartmentById() throws Exception {
		Mockito.when(departmentService.getDepartmentById(101L)).
				thenReturn(Optional.ofNullable(department));
		mockMvc.perform(get("/api/departments/101")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value(department.getName()));
	}
}
