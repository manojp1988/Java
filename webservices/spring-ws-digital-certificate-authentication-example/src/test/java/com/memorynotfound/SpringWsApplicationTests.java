package com.memorynotfound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.memorynotfound.beer.GetBeerRequest;
import com.memorynotfound.beer.ObjectFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(
webEnvironment=WebEnvironment.DEFINED_PORT)
public class SpringWsApplicationTests {

	@Autowired
	private BeerClient beerClient;

	@Test
	public void contextLoads() {
		GetBeerRequest createGetBeerRequest = new ObjectFactory().createGetBeerRequest();
		createGetBeerRequest.setId(1);
		
		beerClient.getBeer(createGetBeerRequest);
		
	}

}
