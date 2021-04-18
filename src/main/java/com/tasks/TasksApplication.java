package com.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tasks.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@CrossOrigin(origins = "http://localhost:3000")
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

}
