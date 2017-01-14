package com.example;

import org.apache.ws.security.WSConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;

@Configuration
public class ClientConfig {
	
	@Bean
    Jaxb2Marshaller jaxb2Marshaller() {

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller
                .setContextPath("com.codenotfound.types.helloworld");
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(
                "http://localhost:8080/springws/ws/helloworld");

        ClientInterceptor[] clientInterceptors = new ClientInterceptor[] {securityInterceptor()};
        webServiceTemplate.setInterceptors(clientInterceptors);
        return webServiceTemplate;
    }

    
    @Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
        wss4jSecurityInterceptor.setSecurementActions("Timestamp UsernameToken");
        wss4jSecurityInterceptor.setSecurementUsername("admin");
        wss4jSecurityInterceptor.setSecurementPassword("secret");
        
        wss4jSecurityInterceptor.setSecurementPasswordType(WSConstants.PW_TEXT);
        return wss4jSecurityInterceptor;
    }
}
