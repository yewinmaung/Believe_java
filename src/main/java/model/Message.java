package model;

import java.sql.Timestamp;

public class Message {
	int id;

String name;
String email;
String message;
Timestamp date;

public Message() {
	
}
public Message(String name, String email, String message) {
	super();
	this.name = name;
	this.email = email;
	this.message = message;
}
public Message(int id, String name, String email, String message, Timestamp date) {
	super();
	this.id=id;
	this.name = name;
	this.email = email;
	this.message = message;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}


}
