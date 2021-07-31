package com.example.BitCoinAnalyzer.util;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRates;

import java.util.List;

public interface IdataStorage {
    void saveBinanceData(List<BinanceHistoricalRates> binanceHistoricalRates);
}
