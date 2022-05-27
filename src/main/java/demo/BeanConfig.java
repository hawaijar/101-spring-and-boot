package demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
	@Bean(name="apollo")
	@Primary
	public Hospital hospital1() {
		return new Hospital("Apollo Hospital");
	}
	@Bean(name="mary")
	public Hospital hospital2() {
		return new Hospital("Mary Hospital");
	}
}
