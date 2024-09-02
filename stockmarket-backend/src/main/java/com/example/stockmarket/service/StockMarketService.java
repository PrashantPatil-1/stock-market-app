package com.example.stockmarket.service;

import com.example.stockmarket.model.StockMarket;
import java.util.List;

public interface StockMarketService {
    void createStock(StockMarket stock);
    void updateStock(StockMarket stock);
    void deleteStock(int id);
    StockMarket getStockById(int id);
    List<StockMarket> searchStocks(String stockname);
    List<StockMarket> getAllStocks();
}
