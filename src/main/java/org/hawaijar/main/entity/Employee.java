package org.hawaijar.main.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long employeeId;
	private String firstName;
	private String lastName;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_number")
	private IdentityCard identityCard;
}
