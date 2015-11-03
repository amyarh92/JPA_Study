package com.libqa.springboot.Repository;

import com.libqa.springboot.Entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by coupang on 2015. 10. 27..
 */
public interface MemberRepository extends CrudRepository<Member, Long> {
	List<Member> findById(Long id);
}