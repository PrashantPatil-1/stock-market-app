package com.example.stockmarket.controller;

import com.example.stockmarket.model.StockMarket;
import com.example.stockmarket.service.StockMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockMarketController {

    @Autowired
    private StockMarketService stockMarketService;
    @GetMapping
    public List<StockMarket> getAllStocks() {
        return stockMarketService.getAllStocks();
    }

    @PostMapping
    public void createStock(@RequestBody StockMarket stock) {
        stockMarketService.createStock(stock);
    }

    @PutMapping
    public void updateStock(@RequestBody StockMarket stock) {
        stockMarketService.updateStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable int id) {
        stockMarketService.deleteStock(id);
    }

    @GetMapping("/{id}")
    public StockMarket getStockById(@PathVariable int id) {
        return stockMarketService.getStockById(id);
    }

    @GetMapping("/search")
    public List<StockMarket> searchStocks(@RequestParam String stockname) {
        return stockMarketService.searchStocks(stockname);
    }
}
