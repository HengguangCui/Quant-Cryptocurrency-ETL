package com.example.BitCoinAnalyzer;

import com.example.BitCoinAnalyzer.entity.BinanceHistoricalRate;
import com.example.BitCoinAnalyzer.util.impl.dataStorageImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class BitCoinAnalyzerApplicationTests {
	@Autowired
	dataStorageImpl dataStorage;
	@Test
	void contextLoads() {
	}
	@Test
	void testStorage() {
		BinanceHistoricalRate r1 = dataStorage.getRate();
		BinanceHistoricalRate r2 = dataStorage.getRate();
		assertThat(r1).isEqualTo(r2);
	}

}
