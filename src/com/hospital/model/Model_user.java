package com.hospital.model;

import java.sql.Timestamp;

public class Model_user {
	
	private int id;
	private String name;
	private String password;
	private Timestamp timestamp;
	
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
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTimestamp() {
		return timestamp.toString();
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Model_user [id=" + id + ", name=" + name + ", password="
				+ password + ", timestamp=" + timestamp + "]";
	}
	public Model_user(int id, String name, String password,
			Timestamp timestamp) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.timestamp = timestamp;
	}
	
	/**
	 * 
	 */
	public Model_user() {
		
	}
	
	
	

}
