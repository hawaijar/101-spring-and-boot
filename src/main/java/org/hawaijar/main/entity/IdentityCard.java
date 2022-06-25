package org.hawaijar.main.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_identity_card")
public class IdentityCard {
	@Id
	private Long cardNumber;
	private String type;

	@OneToOne(fetch = FetchType.LAZY,mappedBy = "identityCard")
	private Employee employee;
}
