package com.memorynotfound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.memorynotfound.beer.GetBeerRequest;
import com.memorynotfound.beer.GetBeerResponse;

@SpringBootApplication
public class RunServer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunServer.class);
        
        BeerClient wsclient = context.getBean(BeerClient.class);
        GetBeerRequest request = new GetBeerRequest();
        request.setId(2);
        GetBeerResponse resp = wsclient.getBeer(request);
        System.out.println("response: " + resp.getBeer().getName());
    }

}
