package com.example.BitCoinAnalyzer.util.impl;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRate;
import com.example.BitCoinAnalyzer.util.IdataStorage;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@Component
public class dataStorageImpl implements IdataStorage {
    @Autowired
    BinanceHistoricalRate rate;
    /**
     * save crawled data into local file for later use
     * @param binanceHistoricalRates
     */
    @Override
    public void saveBinanceData(List<BinanceHistoricalRate> binanceHistoricalRates) {

        try {
            File file = new File("filesystem/binanceRecord.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(0);
            // get last row num
            int lastRowNum = sheet.getLastRowNum();
            // write data after the last row
            for(BinanceHistoricalRate bRates : binanceHistoricalRates) {
                XSSFRow row = sheet.getRow(++lastRowNum);
                row.getCell(0).setCellValue(bRates.getOpenTime());
                row.getCell(1).setCellValue(bRates.getOpen());
                row.getCell(2).setCellValue(bRates.getHigh());
                row.getCell(3).setCellValue(bRates.getLow());
                row.getCell(4).setCellValue(bRates.getClose());
                row.getCell(5).setCellValue(bRates.getVolume());
                row.getCell(6).setCellValue(bRates.getCloseTime());
                row.getCell(7).setCellValue(bRates.getQuoteAssetVolume());
                row.getCell(8).setCellValue(bRates.getNumberOfTrades());
                row.getCell(9).setCellValue(bRates.getTakerBuyBaseAssetVolume());
                row.getCell(10).setCellValue(bRates.getTakerBuyQuoteAssetVolume());
                row.getCell(11).setCellValue(bRates.getIgnore());
            }
            FileOutputStream out = new FileOutputStream("filesystem/binanceRecord.xlsx");
            wb.write(out);
        } catch (Exception e) {
            log.info("Catch exception when saving data into local files: " + e.toString());
        }
    }
    public BinanceHistoricalRate getRate(){ return rate; }
}
