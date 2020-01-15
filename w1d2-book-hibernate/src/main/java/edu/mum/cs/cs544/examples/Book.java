package edu.mum.cs.cs544.examples;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK_HW")
public class Book {
	
	@Id
	@GeneratedValue
	private Long id; 
	private String title; 
	private String ISBN;  
	private String author; 
	private double price; 
	@Temporal(TemporalType.DATE)
	private java.util.Date publish_date;
	
	public Book() {}

	public Book(String title, String iSBN, String author, double price, Date publish_date) {
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public java.util.Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(java.util.Date publish_date) {
		this.publish_date = publish_date;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price
				+ ", publish_date=" + publish_date + "]";
	}
	

}
