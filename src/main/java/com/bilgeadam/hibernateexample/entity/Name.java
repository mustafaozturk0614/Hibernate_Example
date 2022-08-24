package com.bilgeadam.hibernateexample.entity;

import javax.persistence.Embeddable;

/*
 * firstname
 * middlename
 * lastname
 * bir entitiy olmasýn 
 * 
 *  user sýnýfýmýza embed iþlemi yapalým 
 * 
 */
@Embeddable
public class Name {

	private String firstName;
	private String middleName;
	private String lastName;

	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Name() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

}
