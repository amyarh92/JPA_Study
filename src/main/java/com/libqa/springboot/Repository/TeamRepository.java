package com.libqa.springboot.Repository;

import com.libqa.springboot.Entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by coupang on 2015. 10. 27..
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
	List<Team> findByTeamId(Long id);
}
