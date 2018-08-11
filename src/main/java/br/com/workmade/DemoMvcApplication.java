package br.com.workmade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoMvcApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoMvcApplication.class, args);
		
	}
	
	
	@Override // sobreescrever para usar wildfly
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
}
