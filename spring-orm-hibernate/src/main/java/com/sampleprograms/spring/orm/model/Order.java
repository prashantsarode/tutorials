package com.sampleprograms.spring.orm.model;

import java.math.BigDecimal;

public class Order {

	private int id;
	
	private String name;
	
	private BigDecimal totalCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}
