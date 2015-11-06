package com.libqa.springboot.repository;

import com.libqa.springboot.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by coupang on 2015. 10. 27..
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
	List<Team> findByTeamId(Long id);
}
