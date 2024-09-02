package com.example.stockmarket.model;

import java.time.LocalDate;

public class StockMarket {
    private int id;
    private String stockname;
    private LocalDate pricedate;
    private double price;
    private int quantity;
    private long volume;

    public StockMarket(int id, String stockname, LocalDate pricedate, double price, int quantity, long volume) {
        this.id = id;
        this.stockname = stockname;
        this.pricedate = pricedate;
        this.price = price;
        this.quantity = quantity;
        this.volume = volume;
    }

    public StockMarket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public LocalDate getPricedate() {
        return pricedate;
    }

    public void setPricedate(LocalDate localDate) {
        this.pricedate = localDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }
}
