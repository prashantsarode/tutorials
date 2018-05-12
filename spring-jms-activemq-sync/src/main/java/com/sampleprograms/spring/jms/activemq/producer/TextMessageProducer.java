package com.sampleprograms.spring.jms.activemq.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TextMessageProducer {

	private static final Logger LOGGER = LogManager.getLogger(TextMessageProducer.class.getName());

	protected JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final String payload) {

		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				LOGGER.info("Sending Message {}", payload);
				return session.createTextMessage(payload.toString());
			}

		});

	}

}
