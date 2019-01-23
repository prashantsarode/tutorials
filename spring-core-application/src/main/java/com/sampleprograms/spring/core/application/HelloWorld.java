package com.sampleprograms.spring.core.application;

public class HelloWorld {
	
	NameProvider nameProvider;
	
	HelloWorld(NameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public String getName() {
		return nameProvider.getName();
	}
	

}
