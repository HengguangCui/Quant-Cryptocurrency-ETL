package com.example.BitCoinAnalyzer.service;

import com.example.BitCoinAnalyzer.dao.binancemapper.BinanceMapper;
import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BinanceService {
    @Autowired
    BinanceMapper binanceMapper;
    public ArrayList<BinanceHistoricalRates> Sel(long openTime, long closeTime) {return binanceMapper.Sel(openTime, closeTime);}
}
