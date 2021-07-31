package com.example.BitCoinAnalyzer.util.impl;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRates;
import com.example.BitCoinAnalyzer.util.IdataReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class dataReaderImpl implements IdataReader {
    /**
     * read binance data from local files, and return a list of rates
     * @param filePath
     * @return res
     */
    public List<BinanceHistoricalRates> readBinanceData(String filePath){
        List<BinanceHistoricalRates> res = new ArrayList<>();
        try {
            InputStream inputData = new FileInputStream(new File(filePath));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputData);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            for(int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow curRow = sheet.getRow(i);
                BinanceHistoricalRates record = new BinanceHistoricalRates();
                record.setOpenTime((long) curRow.getCell(0).getNumericCellValue());
                record.setOpen(curRow.getCell(1).getNumericCellValue());
                record.setHigh(curRow.getCell(2).getNumericCellValue());
                record.setLow(curRow.getCell(3).getNumericCellValue());
                record.setClose(curRow.getCell(4).getNumericCellValue());
                record.setVolume(curRow.getCell(5).getNumericCellValue());
                record.setCloseTime((long) curRow.getCell(6).getNumericCellValue());
                record.setQuoteAssetVolume(curRow.getCell(7).getNumericCellValue());
                record.setNumberOfTrades((int) curRow.getCell(8).getNumericCellValue());
                record.setTakerBuyBaseAssetVolume(curRow.getCell(9).getNumericCellValue());
                record.setTakerBuyQuoteAssetVolume(curRow.getCell(10).getNumericCellValue());
                record.setIgnore(curRow.getCell(11).getNumericCellValue());
                res.add(record);
            }
        } catch (Exception e) {
            log.info("Exception when reading binance data from local file: " + e.toString());
        }
        return res;
    }
}
