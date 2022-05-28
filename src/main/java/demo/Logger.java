package demo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


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

	@Around("amount()")
	public Object totalAmount(ProceedingJoinPoint joinPoint) throws Throwable {
		String targetClass = joinPoint.getTarget().getClass().getSimpleName();
		String targetMethod = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("targetClass:" + targetClass);
		System.out.println("targetMethod:" + targetMethod);
		System.out.println("Args:" + Arrays.toString(args));
		double response = (double) joinPoint.proceed();
		System.out.println("Method returned:" + response);
		return response;
	}
	@Pointcut("execution(public double demo.ShoppingCart.calculateAmount(..))")
	public void amount(){}

}
