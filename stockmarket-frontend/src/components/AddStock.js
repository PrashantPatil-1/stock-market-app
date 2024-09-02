import React, { useState } from 'react';
import axios from 'axios';

const AddStock = () => {
    const [stockname, setStockname] = useState("");
    const [pricedate, setPricedate] = useState("");
    const [price, setPrice] = useState("");
    const [quantity, setQuantity] = useState("");
    const [volume, setVolume] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post("http://localhost:5454/api/stocks", {
                stockname,
                pricedate,
                price,
                quantity,
                volume,
            });
            alert("Stock added successfully");
            setStockname("");
            setPricedate("");
            setPrice("");
            setQuantity("");
            setVolume("");
        } catch (error) {
            console.error("Error adding stock", error);
        }
    };

    return (
        <div className="container mt-4">
            <h2>Create Stock</h2>
            <form onSubmit={handleSubmit} className="form-group">
                <div className="mb-3">
                    <label htmlFor="stockname" className="form-label">Stock Name:</label>
                    <input
                        id="stockname"
                        type="text"
                        className="form-control"
                        value={stockname}
                        onChange={(e) => setStockname(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="pricedate" className="form-label">Price Date:</label>
                    <input
                        id="pricedate"
                        type="date"
                        className="form-control"
                        value={pricedate}
                        onChange={(e) => setPricedate(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="price" className="form-label">Price:</label>
                    <input
                        id="price"
                        type="number"
                        className="form-control"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="quantity" className="form-label">Quantity:</label>
                    <input
                        id="quantity"
                        type="number"
                        className="form-control"
                        value={quantity}
                        onChange={(e) => setQuantity(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="volume" className="form-label">Volume:</label>
                    <input
                        id="volume"
                        type="number"
                        className="form-control"
                        value={volume}
                        onChange={(e) => setVolume(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary">Add Stock</button>
            </form>
        </div>
    );
};

export default AddStock;
