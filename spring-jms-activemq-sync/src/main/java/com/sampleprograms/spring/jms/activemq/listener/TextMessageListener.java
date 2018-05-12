package com.sampleprograms.spring.jms.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextMessageListener implements MessageListener {
	
	private static final Logger LOGGER = LogManager.getLogger(TextMessageListener.class.getName());

	public void onMessage(Message message) {
		try {
			LOGGER.info("Message Received : {} ", ((TextMessage) message).getText());
		} catch (JMSException jmsException) {
			LOGGER.error(jmsException.getMessage(), jmsException);
		}
	}

}
