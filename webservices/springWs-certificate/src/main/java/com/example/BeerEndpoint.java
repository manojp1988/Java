package com.example;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;

@Endpoint
public class BeerEndpoint {

    public static final String NAMESPACE_URI = "http://codenotfound.com/types/helloworld";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "person")
    @ResponsePayload
    public Greeting getBeer(@RequestPayload Person request)  {
        Greeting beerResponse = new ObjectFactory().createGreeting();
        beerResponse.setGreeting("Hello "+request.getFirstName()+", "+request.getLastName());
        return beerResponse;
    }

}
