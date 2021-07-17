package com.example.BitCoinAnalyzer.dao.binancemapper;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRates;

import java.util.ArrayList;

public interface BinanceMapper {
    ArrayList<BinanceHistoricalRates> Sel(long openTime, long closeTime);
}
