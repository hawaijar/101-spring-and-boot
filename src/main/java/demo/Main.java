package demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class)){
			Doctor doctor = context.getBean(Doctor.class);
			System.out.println("Hospital's name: " + doctor.getHospital().getName());
		}
	}
}
