package com.vincenzo.microservices.currencyconversionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable("from") String from,
                                                          @PathVariable("to") String to,
                                                          @PathVariable("quantity") BigDecimal quantity) {
        return new CurrencyConversion(10001L, from, to, BigDecimal.valueOf(65), quantity, BigDecimal.valueOf(10), "8100");
    }
}
