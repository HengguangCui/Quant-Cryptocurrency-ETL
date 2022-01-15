package com.example.BitCoinAnalyzer.config;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RateConfiguration {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BinanceHistoricalRate getRate() {
        return new BinanceHistoricalRate();
    }
}
