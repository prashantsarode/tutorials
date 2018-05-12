package com.sampleprograms.spring.jms.activemq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sampleprograms.spring.jms.activemq.producer.TextMessageProducer;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger logger = LogManager.getLogger(App.class.getName());
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {

		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloBean");

		System.out.println(helloWorld);
		
		TextMessageProducer textMessageProducer = (TextMessageProducer) applicationContext.getBean("messageProducer");
		
		textMessageProducer.sendMessage("Hello Sanvi!!!");

		logger.warn("Sample Log from App class");

	}
}
