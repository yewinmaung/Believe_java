package model;

public class User {
	int id;
	String name;
	String email;
	String password;
	int type;
public User() {
	
}
public User(int id, String name, String email, String password, int type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
}
