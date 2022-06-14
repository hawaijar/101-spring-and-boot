package org.hawaijar.main.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document("department")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
	private String id;
	@NotNull(message = "Please provide a valid message")
	private String name;
	private String code;
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Department that = (Department) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
