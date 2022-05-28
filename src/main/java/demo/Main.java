package demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class)){
			Shape circle = context.getBean(Circle.class);
			System.out.println(circle.getName());
			Shape triangle = context.getBean(Triangle.class);
			System.out.println(triangle.getName());
		}
	}
}
