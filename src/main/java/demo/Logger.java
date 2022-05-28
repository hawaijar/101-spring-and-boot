package demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
	@Before("execution(public String demo.*.get*())")
	public void log() {
		System.out.println("Logging method called...");
	}
}
