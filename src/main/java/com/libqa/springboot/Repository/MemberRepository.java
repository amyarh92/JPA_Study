package com.libqa.springboot.repository;

import com.libqa.springboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by coupang on 2015. 10. 27..
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findById(Long id);
}

//