package com.memorynotfound;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.jms.JmsMessageSender;

@Configuration
public class SoapClientConfig {
	
	@Autowired
	ConnectionFactory connectionFactory;

    @Bean
    public Jaxb2Marshaller getMarshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.memorynotfound.beer");
        return marshaller;
    }
    
    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(getMarshaller());
        webServiceTemplate.setUnmarshaller(getMarshaller());
        webServiceTemplate.setMessageSender(messageSender());
        webServiceTemplate.setDefaultUri("jms:RequestQueue?deliveryMode=NON_PERSISTENT");
        return webServiceTemplate;
    }
    
    @Bean
    public WebServiceMessageSender messageSender(){
    	JmsMessageSender jmsMessageSender = new JmsMessageSender();
    	jmsMessageSender.setConnectionFactory(connectionFactory);
    	return jmsMessageSender;
    }
    
    @Bean
    public BeerClient beerClient(){
    	return new BeerClient();
    }
    

}
