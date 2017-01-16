package com.memorynotfound;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.server.SoapMessageDispatcher;
import org.springframework.ws.transport.jms.WebServiceMessageListener;

@Configuration
@EnableWs
public class SoapServerConfig extends WsConfigurerAdapter {

	@Autowired
	ConnectionFactory connectionFactory;

	@Bean
	public SaajSoapMessageFactory messageFactory() {
		return new SaajSoapMessageFactory();
	}

	@Bean
	public DefaultMessageListenerContainer messageListenerContainer() {
		DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(connectionFactory);
		messageListenerContainer.setDestinationName("RequestQueue");
		messageListenerContainer.setMessageListener(messageListener());
		return messageListenerContainer;
	}

	@Bean
	public WebServiceMessageListener messageListener() {
		WebServiceMessageListener messageListener = new WebServiceMessageListener();
		messageListener.setMessageFactory(messageFactory());
		messageListener.setMessageReceiver(messageDispatcher());
		return messageListener;
	}

	//Soap message dispatcher hands over the request to the endpoint. In this example, BeerEndpoint.
	//As it is annotated with endpoint
	@Bean
	public SoapMessageDispatcher messageDispatcher() {
		SoapMessageDispatcher messageDispatcher = new SoapMessageDispatcher();
		return messageDispatcher;
	}

}
