package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(StudentRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				repository.save(new Student(null, "Carlos", 28, "C001"));
				repository.save(new Student(null, "Laura", 21, "C002"));
				repository.save(new Student(null, "Inés", 19, "C003"));
				repository.save(new Student(null, "Juan", 20, "C004"));
			}
		};
	}
}
