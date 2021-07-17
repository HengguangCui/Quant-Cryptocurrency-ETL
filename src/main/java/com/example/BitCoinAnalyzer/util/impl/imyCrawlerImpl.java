package com.example.BitCoinAnalyzer.util.impl;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRates;
import com.example.BitCoinAnalyzer.util.ImyCrawler;
import org.json.JSONArray;
import org.springframework.http.HttpEntity;

import java.util.ArrayList;
import java.util.List;

public class imyCrawlerImpl implements ImyCrawler {

    private List<BinanceHistoricalRates> getBinanceHistoricalRatesResponse(String url) {
        List<BinanceHistoricalRates> result = new ArrayList<>();

        HttpEntity<String> jsonString = null;
        JSONArray itemSubArray=null;
        try{
            System.out.println("running url : "+ url);
            //jsonString = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
            // jsonString is a string variable that holds the JSON
            JSONArray itemArray = new JSONArray(jsonString.getBody());
            for (int i = 0; i < itemArray.length(); i++) {
                itemSubArray = itemArray.getJSONArray(i);
                if (itemSubArray.length() != 12) {
                    throw new Exception("retrived data has issue : " + itemSubArray);
                }
                BinanceHistoricalRates rate = new BinanceHistoricalRates();
                rate.setOpenTime(itemSubArray.getLong(0));
                rate.setopen(itemSubArray.getDouble(1));
                rate.sethigh(itemSubArray.getDouble(2));
                rate.setLow(itemSubArray.getDouble(3));
                rate.setClose(itemSubArray.getDouble(4));
                rate.setVolume(itemSubArray.getDouble(5));
                rate.setCloseTime(itemSubArray.getLong(6));
                rate.setQuoteAssetVolume(itemSubArray.getDouble(7));
                rate.setNumberOfTrades(itemSubArray.getInt(8));
                rate.setTakerBuyBaseAssetVolume(itemSubArray.getDouble(9));
                rate.setTakerBuyQuoteAssetVolume(itemSubArray.getDouble(10));
                rate.setIgnore(itemSubArray.getDouble(11));
                result.add(rate);
            }
        }catch (Exception e) {
            System.out.println(String.format("exception url : %s",url));
            if(jsonString!=null)
                System.out.println("response is " + jsonString.getBody());
            System.out.println("Problem item sub array + " + itemSubArray);
            e.printStackTrace();
            return null;
        }
        return result;

    }
}
