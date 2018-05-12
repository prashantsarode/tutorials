package com.sampleprograms.spring.jms.activemq.listener;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class TextMessageListenerTest extends TestCase {

	private TextMessageListener underTest = new TextMessageListener();

	private Logger logger = (Logger) LogManager.getLogger(TextMessageListener.class);;
	@Captor
	private ArgumentCaptor<LogEvent> captorLoggingEvent;
	@Mock
	Appender mockAppender;

	Message message;

	@Before
	public void setup() throws JMSException {
		when(mockAppender.getName()).thenReturn("MockAppender");
		when(mockAppender.isStarted()).thenReturn(true);

		logger.addAppender(mockAppender);
		logger.setLevel(Level.INFO);

		message = mock(TextMessage.class);
	}

	@Test
	public void when_message_received_no_error_is_raised() throws JMSException {
		when(((TextMessage) message).getText()).thenReturn("Hello World!!!");

		underTest.onMessage(message);

		verifyErrorMessages("Message Received : Hello World!!! ");
	}

	@Test
	public void when_jms_exception_error_is_logged() throws JMSException {
		when(((TextMessage) message).getText()).thenThrow(JMSException.class);

		underTest.onMessage(message);

		verify(mockAppender, times(1)).append(captorLoggingEvent.capture());
	}

	private void verifyErrorMessages(String message) {
		verify(mockAppender, times(1)).append(captorLoggingEvent.capture());
		for (LogEvent loggingEvent : captorLoggingEvent.getAllValues()) {
			assertEquals(message, loggingEvent.getMessage().getFormattedMessage());
		}
	}

	@After
	public void tearDown() {
		logger.removeAppender(mockAppender);
	}

}
