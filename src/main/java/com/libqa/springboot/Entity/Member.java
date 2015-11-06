package com.libqa.springboot.entity;

import javax.persistence.*;

/**
 * Created by Amy on 2015. 10. 27..
 */

@Entity
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "NUMBER")
	private Long mem_no;

	@Column(name = "ID")
	private String mem_id;


	@Column(name = "NAME")
	private String mem_name;

	//맵핑 정보가 없는 필드
	// --> 어노테이션 생략시 필드명을 사용해 컬럼명으로 매핑
	// --> 대소문자 구분시 명시적으로 매핑할 필요가 있음
	private Integer age;

	//연관관계 매핑
	@ManyToOne(optional = false)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Member(String mem_name, Team team) {
		this.mem_name = mem_name;
		this.team = team;
	}

	@Override
	public String toString() {

		return String.format("Member[mem_NO='%d', mem_ID='%s', mem_NAME='%s', mem_age='%s']", mem_no, mem_id, mem_name, age);
	}

	//연관관계 설정
	public void setTeam(Team team) {
		this.team = team;
	}

	//Getter, Setter
	public Long getMem_no() {
		return mem_no;
	}

	public void setMem_no(Long mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_username() {
		return mem_name;
	}

	public void setMem_username(String mem_name) {
		this.mem_name = mem_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}


}
