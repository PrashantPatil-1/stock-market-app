package com.example.stockmarket.service;

import com.example.stockmarket.dao.StockMarketDao;
import com.example.stockmarket.model.StockMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockMarketServiceImpl implements StockMarketService {

    @Autowired
    private StockMarketDao stockMarketDao;

    @Override
    @Transactional
    public void createStock(StockMarket stock) {
        stockMarketDao.insertStock(stock);
    }
    @Override
    public List<StockMarket> getAllStocks() {
        return stockMarketDao.getAllStocks();
    }

    @Override
    @Transactional
    public void updateStock(StockMarket stock) {
        stockMarketDao.updateStock(stock);
    }

    @Override
    @Transactional
    public void deleteStock(int id) {
        stockMarketDao.deleteStock(id);
    }

    @Override
    public StockMarket getStockById(int id) {
        return stockMarketDao.getStockById(id);
    }

    @Override
    public List<StockMarket> searchStocks(String stockname) {
        return stockMarketDao.searchStocks(stockname);
    }
}
