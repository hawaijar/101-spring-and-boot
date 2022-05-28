package demo;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "demo")
@EnableAspectJAutoProxy(proxyTargetClass=true)
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
