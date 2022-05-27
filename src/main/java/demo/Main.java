package demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("demo")){
			Hospital hospital = context.getBean("apollo",Hospital.class);
			System.out.println("Hospital's name: " + hospital.getName());
		}
	}
}
