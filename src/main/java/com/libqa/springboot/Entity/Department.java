package com.libqa.springboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amy on 2015. 11. 3..
 */
@Entity
@Table(name = "DEPARTMENT")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID")
	private Long dep_id;

	@Column(name = "DEPARTMENT_NAME")
	private String dep_name;

	@OneToMany(mappedBy = "department")
	private List<Team> teams = new ArrayList<Team>();

	public Department(String dep_name) {
		this.dep_name = dep_name;
	}

	//Getter, Setter
	public Long getDep_id() {
		return dep_id;
	}

	public void setDep_id(Long dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
