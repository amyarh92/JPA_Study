package com.libqa.springboot.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by coupang on 2015. 10. 27..
 */

@Entity
@Table(name = "CLASS")
public class Class {

	@Id
	@Column(name = "CLASS_ID")
	private String class_id;

	private String class_name;

	@OneToMany
	@JoinColumn(name = "CLASS_ID")  //MEMBER 테이블의 TEAM_ID (FK)
	private List<Team> teams = new ArrayList<Team>();



	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
}
