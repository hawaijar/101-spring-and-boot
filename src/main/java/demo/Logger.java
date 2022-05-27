package demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
	@Before("execution(* demo.ShoppingCart.checkout(*))")
	public void log() {
		System.out.println("Logging method called...");
	}
}
