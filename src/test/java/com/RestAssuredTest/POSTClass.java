package com.RestAssuredTest;

public class POSTClass {

	public POSTClass(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	int id;
	String title;
	String author;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}	
}
