package com.example.stockmarket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockmarketApplication {
    private static final Logger logger = LogManager.getLogger(StockmarketApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(StockmarketApplication.class, args);
        logger.info("StockMarketApplication started successfully.");

	}

}
