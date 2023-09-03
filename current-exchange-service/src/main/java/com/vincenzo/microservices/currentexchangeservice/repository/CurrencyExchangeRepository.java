package com.vincenzo.microservices.currentexchangeservice.repository;

import com.vincenzo.microservices.currentexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    public CurrencyExchange findByFromAndTo(String from, String to);
}
