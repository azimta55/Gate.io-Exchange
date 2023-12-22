package xtg.gateio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.gate.gateapi.ApiClient;
import io.gate.gateapi.ApiException;
import io.gate.gateapi.Configuration;
import io.gate.gateapi.GateApiException;
import io.gate.gateapi.api.EarnUniApi;
import io.gate.gateapi.models.UniCurrency;




@RestController
public class Controller {
	
	
	
	
	
	
	   @RequestMapping(value = "/getListOfUniCurrency", method = RequestMethod.GET, produces = "application/json")
	    public List<UniCurrency>   getUniswapPools() throws IOException {
		   List<UniCurrency> result = null;
		   ApiClient defaultClient = Configuration.getDefaultApiClient();
	        defaultClient.setBasePath("https://api.gateio.ws/api/v4");

	        EarnUniApi apiInstance = new EarnUniApi(defaultClient);
	        try {
	         result = apiInstance.listUniCurrencies();
	            System.out.println(result);
	        } catch (GateApiException e) {
	            System.err.println(String.format("Gate api exception, label: %s, message: %s", e.getErrorLabel(), e.getMessage()));
	            e.printStackTrace();
	        } catch (ApiException e) {
	            System.err.println("Exception when calling EarnUniApi#listUniCurrencies");
	            System.err.println("Status code: " + e.getCode());
	            System.err.println("Response headers: " + e.getResponseHeaders());
	            e.printStackTrace();
	        }
				
			
			return result;
	    }
	
	

}
