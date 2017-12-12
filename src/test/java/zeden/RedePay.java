package zeden;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zeden.endpoint.endpoint;
import br.com.zeden.model.CustomerObject;
import br.com.zeden.model.CustomerRedePay;
import br.com.zeden.service.IRest;

public class RedePay implements IRest {
	
	private CustomerObject customer = new CustomerObject();

	@Test
	@Override
	public void postRequest() {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
         
		customer.setEmail("servicoyaman727017@userede.com.br");
		customer.setFingerprint(2893866862l);
		// Jackson ObjectMapper to convert requestBody to JSON
		String json;
		try {
			json = new ObjectMapper().writeValueAsString(customer);
			HttpEntity<String> entity = new HttpEntity<>(json, headers);

			ResponseEntity<CustomerRedePay> response = template.postForEntity(endpoint.ENDPOINTIDENTIFICATION, entity, CustomerRedePay.class);
			CustomerRedePay customerRedePay = response.getBody();
			HttpStatus status = response.getStatusCode();
			System.out.println(customerRedePay.getIdentToken() + status);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getResquest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void putRequest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRequest() {
		// TODO Auto-generated method stub

	}

}
