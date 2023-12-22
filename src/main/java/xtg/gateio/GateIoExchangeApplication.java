package xtg.gateio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.gate.gateapi.ApiClient;
import io.gate.gateapi.ApiException;
import io.gate.gateapi.Configuration;
import io.gate.gateapi.GateApiException;
import io.gate.gateapi.api.AccountApi;
import io.gate.gateapi.models.AccountDetail;




@SpringBootApplication
public class GateIoExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateIoExchangeApplication.class, args);

        try {
            ApiClient defaultClient = Configuration.getDefaultApiClient();
            defaultClient.setBasePath("https://api.gateio.ws/api/v4");
            defaultClient.setApiKeySecret("c5d7fccd82a055da38a33f96e9ee38a9", "4a32e6a5518117832b7ebda60d3ba719eb4f56667d2ad52b3756033ac9aec6f2");

            AccountApi apiInstance = new AccountApi(defaultClient);
            AccountDetail result = apiInstance.getAccountDetail();
            System.out.println(result);
        } catch (GateApiException e) {
            System.err.println(String.format("Gate API exception, label: %s, message: %s", e.getErrorLabel(), e.getMessage()));
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountApi#getAccountDetail");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
