package com.arise.hibernateProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JustEntity {

	@Id @GeneratedValue
	private int jId;
	private String name;
	public int getjId() {
		return jId;
	}
	public void setjId(int jId) {
		this.jId = jId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
