package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;

public class RunClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        BeerClient wsclient = context.getBean(BeerClient.class);
        Person request = new ObjectFactory().createPerson();
        request.setFirstName("John");
        request.setLastName("Doyle");
        
        Greeting beer = wsclient.getBeer(request);
        System.out.println("response: " + beer);
    }

}
