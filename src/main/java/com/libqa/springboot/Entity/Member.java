package com.libqa.springboot.Entity;

import javax.persistence.*;

/**
 * Created by coupang on 2015. 10. 27..
 */

@Entity
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String username;

	//맵핑 정보가 없는 필드
	// --> 어노테이션 생략시 필드명을 사용해 컬럼명으로 매핑
	// --> 대소문자 구분시 명시적으로 매핑할 필요가 있음
	private Integer age;


	//연관관계 매핑
	private Team team;
	//연관관계 설정
	public void setTeam(Team team) {
		this.team = team;
	}

	//Getter, Setter
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}

	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}

	public Integer getAge(){
		return age;
	}
	public void setAge(Integer age){
		this.age = age;
	}
}
