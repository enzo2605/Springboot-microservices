package com.vincenzo.microservices.currencyconversionservice.controller;

import com.vincenzo.microservices.currencyconversionservice.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable("from") String from,
                                                          @PathVariable("to") String to,
                                                          @PathVariable("quantity") BigDecimal quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        /*
            Call the API, the service currency-exchange using RestTemplate
            - pass the link of the API
            - pass the responseType
            - pass an HashMap containing the parameter
        */
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables);

        // Get the result from the call of the API
        CurrencyConversion currencyConversion = responseEntity.getBody();

        // Return the result using the values returned from the call
        return new CurrencyConversion(currencyConversion.getId(),
                                      from, to,
                                      currencyConversion.getConversionMultiple(),
                                      quantity,
                                      quantity.multiply(currencyConversion.getConversionMultiple()),
                                      currencyConversion.getEnvironment());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable("from") String from,
                                                          @PathVariable("to") String to,
                                                          @PathVariable("quantity") BigDecimal quantity) {
        // Get the result from the call of the API
        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        // Return the result using the values returned from the call
        return new CurrencyConversion(currencyConversion.getId(),
                from, to,
                currencyConversion.getConversionMultiple(),
                quantity,
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " " + "feign");
    }
}
