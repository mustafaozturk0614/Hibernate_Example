package com.bilgeadam.hibernateexample.entity;

import javax.persistence.Embeddable;

/*
 * 
 * streetName
 * country 
 * city
 * 
 */
@Embeddable
public class Address {

	private String streetName;
	private String country;
	private String city;

	public Address(String streetName, String country, String city) {
		super();
		this.streetName = streetName;
		this.country = country;
		this.city = city;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", country=" + country + ", city=" + city + "]";
	}

}
