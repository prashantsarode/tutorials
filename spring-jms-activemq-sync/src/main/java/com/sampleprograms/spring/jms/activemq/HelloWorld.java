package com.sampleprograms.spring.jms.activemq;

public class HelloWorld {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hello " + name + "!!!";
	}
	
	
	
}
