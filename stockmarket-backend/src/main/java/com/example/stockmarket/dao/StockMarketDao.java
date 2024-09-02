package com.example.stockmarket.dao;

import com.example.stockmarket.model.StockMarket;
import java.util.List;

public interface StockMarketDao {
    void insertStock(StockMarket stock);
    void updateStock(StockMarket stock);
    void deleteStock(int id);
    StockMarket getStockById(int id);
    List<StockMarket> searchStocks(String stockname);
    List<StockMarket> getAllStocks();
}
