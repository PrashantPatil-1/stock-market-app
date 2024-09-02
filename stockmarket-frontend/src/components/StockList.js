import React, { useState, useEffect } from "react";
import axios from "axios";

const StockList = () => {
  const [stocks, setStocks] = useState([]);
  const [search, setSearch] = useState("");
  const [filteredStocks, setFilteredStocks] = useState([]);

  useEffect(() => {
    fetchStocks();
  }, []);

  const fetchStocks = async () => {
    try {
      const response = await axios.get("http://localhost:5454/api/stocks");
      setStocks(response.data);
      setFilteredStocks(response.data);
    } catch (error) {
      console.error("Error fetching stocks", error);
    }
  };

  const handleSearch = async () => {
    try {
      const response = await axios.get(
        `http://localhost:5454/api/stocks/search?stockname=${search}`
      );
      setFilteredStocks(response.data);
    } catch (error) {
      console.error("Error searching stocks", error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:5454/api/stocks/${id}`);
      setStocks(stocks.filter((stock) => stock.id !== id));
      setFilteredStocks(filteredStocks.filter((stock) => stock.id !== id));
    } catch (error) {
      console.error("Error deleting stock", error);
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4">Stock List</h2>
      <div className="mb-4 d-flex">
        <input
          type="text"
          className="form-control me-2"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          placeholder="Search by stock name"
        />
        <button onClick={handleSearch} className="btn btn-primary">Search</button>
      </div>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>ID</th>
            <th>Stock Name</th>
            <th>Price Date</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Volume</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredStocks.map((stock) => (
            <tr key={stock.id}>
              <td>{stock.id}</td>
              <td>{stock.stockname}</td>
              <td>{stock.pricedate}</td>
              <td>{stock.price}</td>
              <td>{stock.quantity}</td>
              <td>{stock.volume}</td>
              <td>
                <button onClick={() => handleDelete(stock.id)} className="btn btn-danger btn-sm">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StockList;
