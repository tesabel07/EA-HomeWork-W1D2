package edu.mum.cs.cs544.examples;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSON_HW")
public class Person {
	
	@Id
	@GeneratedValue
	private long id; 
	private String firstname; 
	private String lastname; 
	@Temporal(TemporalType.DATE)
	private Date dateofbirth; 
	
	public Person() {}

	public Person(String firstname, String lastname, Date dateofbirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dateofbirth="
				+ dateofbirth + "]";
	}
	
	

}
