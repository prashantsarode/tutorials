package com.sampleprograms.spring.core.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloBean");
		System.out.println(helloWorld.getName());

	}
}
