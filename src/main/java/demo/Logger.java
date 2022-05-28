package demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
	@Before("allGetters()")
	public void log1() {
		System.out.println("log1 method called...");
	}
	@Before("allGetters()")
	public void log2() {
		System.out.println("log2 method called...");
	}
	@Pointcut("execution(public String demo.*.get*())")
	public void allGetters(){}
	@Before("security()")
	public void authenticate() {
		System.out.println("Authentication required...");
	}
	@Pointcut("within(demo.ShoppingCart)")
	public void security(){}
}
