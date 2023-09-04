package model;

import java.sql.Timestamp;

public class Course {
int id;
String name;
String img;
Timestamp date;
int type;
String price;
String link;
public Course() {
	
}
public Course(int id, String name,String img, int type,String link,Timestamp date) {
	super();
	this.id = id;
	this.name = name;
	this.img=img;
	this.type = type;
	this.price = price;
	this.link = link;
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
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getLink() {
	return link;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
public void setLink(String link) {
	this.link = link;
}

}
