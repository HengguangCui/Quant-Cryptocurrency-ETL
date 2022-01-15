package com.example.BitCoinAnalyzer.service;

import com.example.BitCoinAnalyzer.dao.binancemapper.BinanceMapper;
import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static java.lang.String.format;

//@Service
public class BinanceService {
    @Autowired
    BinanceMapper binanceMapper;

    /**
     *
     * @param openTime
     * @param closeTime
     * @return
     */
    public ArrayList<BinanceHistoricalRate> select(long openTime, long closeTime) {
        if(openTime <= closeTime) {
            // TODO: time transfer
            // TODO: HOW TO FORMAT?
            final String msg = format("Close time before open time is invalid. Close time: %s, Open time: %s", openTime, closeTime);
            throw new IllegalStateException(msg);
        }
        return binanceMapper.select(openTime, closeTime);
    }
}

