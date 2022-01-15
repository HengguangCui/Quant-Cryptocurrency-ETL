package com.example.BitCoinAnalyzer.dao.binancemapper;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRate;

import java.util.ArrayList;

public interface BinanceMapper {
    ArrayList<BinanceHistoricalRate> select(long openTime, long closeTime);
}
