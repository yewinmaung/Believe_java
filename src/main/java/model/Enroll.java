package model;

import java.sql.Timestamp;

public class Enroll {
	int id;
	String name;
	int class_id;
	String email;
	int user_id;
	Timestamp date;

	public Enroll() {

	}

	public Enroll(int id, String name, int class_id, String email, int user_id, Timestamp date) {
		this.id = id;
		this.name = name;
		this.class_id=class_id;
		this.email=email;
		this.user_id=user_id;
		this.date=date;
	}

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

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
