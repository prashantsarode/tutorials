package com.sampleprograms.spring.jms.activemq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger logger = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloBean");

		System.out.println(helloWorld);

		logger.warn("Sample Log from App class");

	}
}
