package com.memorynotfound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.memorynotfound.beer.GetBeerRequest;
import com.memorynotfound.beer.GetBeerResponse;

@Component
public class BeerClient {

	@Autowired
	private WebServiceTemplate template;
	
    public GetBeerResponse getBeer(GetBeerRequest request){
        return (GetBeerResponse) template
                .marshalSendAndReceive(request);

    }
}
