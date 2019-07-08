package com.Sprinkle.EMS;

import java.io.Serializable;

public class Address implements Serializable {
	
	private String street;
	private String City ;
	private String State;
	private int Zip;
	
	public Address(String street, String City, String State, int Zip) {
		this.City = City;
		this.State = State;
		this.Zip = Zip;
		this.street = street;
				
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getZip() {
		return Zip;
	}
	public void setZip(int zip) {
		Zip = zip;
	} 
				

}
