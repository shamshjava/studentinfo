package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringJpaExampleApplication extends SpringBootServletInitializer/* implements CommandLineRunner*/{
	
	/*@Autowired
    private ApplicationContext context;*/

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringJpaExampleApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaExampleApplication.class, args);
		System.out.println("My Spring");
	}
	/*public void run(String...args) throws Exception {
        String[] beans = context.getBeanDefinitionNames();

        for (String bean: beans) {
            System.out.println(bean);
        }
    }*/
}
