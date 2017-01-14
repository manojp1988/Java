package com.memorynotfound;

import com.memorynotfound.beer.GetBeerRequest;
import com.memorynotfound.beer.GetBeerResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        BeerClient wsclient = context.getBean(BeerClient.class);
        GetBeerRequest request = new GetBeerRequest();
        request.setId(2);
        GetBeerResponse resp = wsclient.getBeer(request);
        System.out.println("response: " + resp);
    }

}
