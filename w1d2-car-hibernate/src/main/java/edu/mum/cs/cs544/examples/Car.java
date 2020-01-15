package edu.mum.cs.cs544.examples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR_HW")
public class Car {
	
	private Long id;
	private String brand;
	private int year;
	private double price;
	
	public Car() {}

	public Car(String brand, int year, double price) {
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	@Column
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", year=" + year + ", price=" + price + "]";
	}
	
	

}
