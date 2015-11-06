package com.libqa.springboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 2015. 10. 27..
 */

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEAM_ID")
	private Long team_id;

	@Column(name = "TEAM_NAME")
	private String team_name;

	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<Member>();

	//연관관계 매핑
	@ManyToOne(optional = false)
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	public Team(String team_name, Department department) {
		this.team_name = team_name;
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("Team[Tema_ID='%d',Team_NAME='%s']",team_id,team_name);
	}

	//Getter, Setter
	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
