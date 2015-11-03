package com.libqa.springboot.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by coupang on 2015. 10. 27..
 */

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	private String name;

	@OneToMany
	@JoinColumn(name = "TEAM_ID")  //MEMBER 테이블의 TEAM_ID (FK)
	private List<Member> members = new ArrayList<Member>();


	//연관관계 매핑
	private Class aClass;
	//연관관계 설정
	public void setTeam(Class bClass) {
		this.aClass = bClass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
