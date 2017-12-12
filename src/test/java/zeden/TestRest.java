package zeden;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zeden.endpoint.endpoint;
import br.com.zeden.model.AccountCredentials;
import br.com.zeden.model.Address;
import br.com.zeden.model.Customer;
import br.com.zeden.model.Datum;
import br.com.zeden.model.Sector;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRest.class)
public class TestRest{
	
	private static String watchedLog;
	private Address address;
	private Customer customer;
	private AccountCredentials credentials;
	
	
	@Rule
	public TestWatcher watcher = new TestWatcher() {
		
		protected void failed(Throwable e, org.junit.runner.Description description) {
			
			watchedLog+= description + "\n";
			System.out.println(watchedLog);
			
		}
		
		protected void succeeded(org.junit.runner.Description description) {
			
			watchedLog+= description + " " + "success!\n";
			System.out.println(watchedLog);
		};
	};
	
	
	public void testar() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Sector> response = restTemplate.getForEntity(endpoint.ENDPOINTSECTORS,Sector.class );
	    Sector sectors = response.getBody();
	 
	    for(Datum datum : sectors.getData()) {
	    	   if(datum.getName().equals( "Varejista")) {
	    		  System.out.println(datum.getName());
	    		   Assert.assertEquals("Varejista", datum.getName());
	    		   
	    	   }
	    }
	}

	@Test
	public void postrequest() {
		
		
		//HashedMap requestBody = new HashedMap();
		//requestBody.put("eventType", "testDeliveryEvent");
		//requestBody.put("sendType", "SINGLE");
        RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Jackson ObjectMapper to convert requestBody to JSON
		String json;
		try {
			json = new ObjectMapper().writeValueAsString(customer);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			template.postForEntity(endpoint.ENDPOINTWORKERS, entity, String.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
