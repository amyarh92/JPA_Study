package com.libqa.springboot;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by AMY on 2015. 10. 16..
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
