package com.example.BitCoinAnalyzer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BinanceHistoricalRates {
    private long openTime;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private long closeTime;
    private double quoteAssetVolume;
    private int numberOfTrades;
    private double takerBuyBaseAssetVolume;
    private double takerBuyQuoteAssetVolume;
    private double ignore;
}
