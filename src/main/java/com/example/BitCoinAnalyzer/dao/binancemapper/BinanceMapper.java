package com.example.BitCoinAnalyzer.dao.binancemapper;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRates;

import java.util.ArrayList;

public interface BinanceMapper {
    ArrayList<BinanceHistoricalRates> select(long openTime, long closeTime);
}
