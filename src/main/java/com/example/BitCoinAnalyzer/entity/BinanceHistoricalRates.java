package com.example.BitCoinAnalyzer.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
