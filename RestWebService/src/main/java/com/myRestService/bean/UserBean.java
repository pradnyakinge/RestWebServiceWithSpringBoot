package com.myRestService.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserBean {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 2, max = 6, message = "name should be atleast 2 char long")
	private String name;
	
	@Past(message = "future date shoudn't be accepted.")
	private Date birthdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public UserBean(int id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public UserBean()
	{
		
	}
}
