package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Hospital {
	@Value("Morning Sky Hospital")
	private String name;

	public Hospital() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
