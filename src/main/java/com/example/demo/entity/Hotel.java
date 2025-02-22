package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  
public class Hotel {

	
	@Id   //it will be serve as primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY)  //use for genrate unique id for each hotels
	private Long id;
	
	private String name;
	
	private String hoteltype;
	
	private String quality;

	
	//parameterized constructor
	public Hotel(Long id, String name, String hoteltype, String quality) {
		super();
		this.id = id;
		this.name = name;
		this.hoteltype = hoteltype;
		this.quality = quality;
	}
	
	//Non parameterised constructor
	public Hotel() {
		
	}

	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHoteltype() {
		return hoteltype;
	}

	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	
	//to String method
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", hoteltype=" + hoteltype + ", quality=" + quality + "]";
	}
	
	
	
	
}
