package com.gagan.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange")
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000") // In the environment variable _SERVICE_HOST is a suffix will be added by Kubernetes
//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_MY_URI:http://localhost}:8000") // CURRENCY_EXCHANGE_MY_URI is the custom environment variable
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
