package com.libqa.springboot;

import com.libqa.springboot.Entity.Member;
import com.libqa.springboot.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Amy on 2015. 10. 13..
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

//
//	public static void main(String[] args){
//		SpringApplication.run(Application.class, args);
//		System.out.println("###### Libqa Spring Boot Application Started! ######");
//	}

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... strings) throws Exception {
//		// save customers
//		repository.save(new Customer("Jack", "Bauer"));
//		repository.save(new Customer("Chloe", "O'Brian"));
//		repository.save(new Customer("Kim", "Bauer"));
//		repository.save(new Customer("David", "Palmer"));
//		repository.save(new Customer("Michelle", "Dessler"));
//		repository.save(new Customer("Amy", "Hoang")); // line당 insert가 될것이다 - 퀵님
//
//		System.out.println("Customers found with findAll()");
//		System.out.println("------------------------------");
//		for (Customer customer : repository.findAll()){
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer by ID
//		Customer customer = repository.findOne(1L);
//		System.out.println("Customer found with findOne(1L):");
//		System.out.println("--------------------------------");
//		System.out.println(customer);
//		System.out.println();
//
//		// fetch customers by last name
//		System.out.println("Customer found with findByLastName('Bauer'):");
//		System.out.println("--------------------------------------------");
//		for (Customer bauer : repository.findByLastName("Bauer")) {
//			System.out.println(bauer);
//		}

		homework1();
	}


	public void homework1() {
		//[엔티티 매니저 팩토리] - 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

		//
		EntityManager em = emf.createEntityManager();

		//
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			logic(em);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();

	}

	public static void logic(EntityManager em) {

		Long id = 1L;
		Member member = new Member();
		member.setId(id);
		member.setUsername("지한");
		member.setAge(2);

		//등록
		em.persist(member);

		//수정
		member.setAge(20);

		//한건 조회
		Member findMember = em.find(Member.class, id);
		System.out.printf("findMember=%s, age=%s\n", findMember.getUsername(), findMember.getAge());

		//목록 조회
//		List<Member> memberList = em.createQuery("select m from MEMBER m", Member.class).getResultList();
//		System.out.printf("members.size=%s\n", memberList.size());

		//삭제
//		em.remove(member);
	}


}
