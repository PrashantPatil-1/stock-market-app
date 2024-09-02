package com.example.stockmarket.dao;

import com.example.stockmarket.model.StockMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockMarketDaoImpl implements StockMarketDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<StockMarket> getAllStocks() {
        String sql = "SELECT * FROM stockmarket";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StockMarket.class));
    }

    @Override
    public void insertStock(StockMarket stock) {
        String sql = "INSERT INTO stockmarket (stockname, pricedate, price, quantity, volume) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, stock.getStockname(), stock.getPricedate(), stock.getPrice(), stock.getQuantity(), stock.getVolume());
    }

    @Override
    public void updateStock(StockMarket stock) {
        String sql = "UPDATE stockmarket SET stockname = ?, pricedate = ?, price = ?, quantity = ?, volume = ? WHERE id = ?";
        jdbcTemplate.update(sql, stock.getStockname(), stock.getPricedate(), stock.getPrice(), stock.getQuantity(), stock.getVolume(), stock.getId());
    }

    @Override
    public void deleteStock(int id) {
        String sql = "DELETE FROM stockmarket WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public StockMarket getStockById(int id) {
        String sql = "SELECT * FROM stockmarket WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StockMarket.class), id);
    }

    @Override
    public List<StockMarket> searchStocks(String stockname) {
        String sql = "SELECT * FROM stockmarket WHERE stockname LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StockMarket.class), "%" + stockname + "%");
    }

}
