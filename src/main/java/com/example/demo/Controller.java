package com.example.demo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

RestTemplate restTemplate=new RestTemplate();

@RequestMapping(value="/exchange/{baseCurrency}/{targetCurrency}")
public Map<String,String> getCurrencyConvert(@PathVariable(value="baseCurrency") String bscurr, @PathVariable(value="targetCurrency") String trcurr) {
	// CloseableHttpClient httpClient = HttpClients.createDefault();
	Output result=restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base="+bscurr, Output.class);
	 
	Map<String,String> ret=new HashMap<String, String>(1);
ret.put(trcurr, result.getRates().get(trcurr));

return ret;
	
}
/**
 * @author subha-pc
 *
 */
static public class Output implements Serializable
{
	Map<String,String>rates;
	String base;
	String date;
	public Map<String, String> getRates() {
		return rates;
	}
	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
}




