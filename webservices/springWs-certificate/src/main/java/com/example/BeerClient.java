package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.Person;

public class BeerClient {

	@Autowired
	private WebServiceTemplate template;
	
    public Greeting getBeer(Person request){
        return (Greeting) template
                .marshalSendAndReceive(request);

    }
}
