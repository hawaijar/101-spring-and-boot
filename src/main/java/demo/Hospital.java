package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class Hospital implements BeanNameAware {
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

	@Override
	public void setBeanName(String name) {
		System.out.println("Before bean initialisation");
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("After bean initialisation");
	}
}
