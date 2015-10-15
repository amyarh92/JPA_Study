package com.libqa.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Amy on 2015. 10. 13..
 */

@SpringBootApplication
public class Application {
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
		System.out.println("###### Libqa Spring Boot Application Started! ######");
	}
}
