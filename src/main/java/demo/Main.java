package demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class)){
			ShoppingCart cart = context.getBean(ShoppingCart.class);
			cart.addItems();
			cart.checkout("DONE");
			cart.logout();
		}
	}
}
