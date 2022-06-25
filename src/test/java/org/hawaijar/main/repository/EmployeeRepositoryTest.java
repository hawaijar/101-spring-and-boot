package org.hawaijar.main.repository;

import org.hawaijar.main.entity.Employee;
import org.hawaijar.main.entity.EmployeeRepository;
import org.hawaijar.main.entity.IdentityCard;
import org.hawaijar.main.entity.IdentityCardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private IdentityCardRepository identityCardRepository;
	@Test
	public void saveEmployeeWithIdentityCard() {
		IdentityCard identityCard = IdentityCard.builder()
				.cardNumber(123L)
				.type("GREEN")
				.build();
		identityCardRepository.save(identityCard);

		Employee employee = Employee.builder()
				.firstName("John")
				.lastName("Doe")
				.build();
		employee.setIdentityCard(identityCard);
		employeeRepository.save(employee);
	}
	@Test
	public void testGetEmployeeWithIdentityCard() {
		IdentityCard identityCard = identityCardRepository.findById(123L).orElse(null);

		if(identityCard != null) {
			Employee employee = identityCard.getEmployee();
			assertEquals(employee.getFirstName(), "John");
			assertEquals(employee.getLastName(), "Doe");
		}
	}
}
