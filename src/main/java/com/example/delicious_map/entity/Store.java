package com.example.delicious_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store_map")
public class Store {
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "evaluate")
	private float evaluate =5;

	public Store() {
		super();
	}

	
	public Store(String name, String city, float evaluate) {
		super();
		this.name = name;
		this.city = city;
		this.evaluate = evaluate;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(float evaluate) {
		this.evaluate = evaluate;
	}
}
