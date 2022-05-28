package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
	@Value("Yes, I'm a circle")
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
