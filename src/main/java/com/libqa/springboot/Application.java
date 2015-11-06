package com.libqa.springboot;

import com.libqa.springboot.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Amy on 2015. 10. 13..
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private RepositoryService repositoryService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryService.saveMember();
		repositoryService.print();
		repositoryService.lazyEntityPrint();

		repositoryService.deletContraintKey();
		repositoryService.print();
	}
}

