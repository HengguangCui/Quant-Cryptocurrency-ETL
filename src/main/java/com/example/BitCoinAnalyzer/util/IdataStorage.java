package com.example.BitCoinAnalyzer.util;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRate;

import java.util.List;

public interface IdataStorage {
    void saveBinanceData(List<BinanceHistoricalRate> binanceHistoricalRates);
}
