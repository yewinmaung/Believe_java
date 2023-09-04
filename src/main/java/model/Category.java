package model;

import java.sql.Timestamp;

public class Category {
int id;
String title;
String img;
String price;
Timestamp date;
   public Category() {
	   
   }
	public Category(int id, String title, String img, String price, Timestamp date) {
		this.id=id;
		this.title=title;
		this.img=img;
		this.price=price;
		this.date=date;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}


}
