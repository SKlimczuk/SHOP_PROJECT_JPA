package com.app.service;

import com.app.model.dto.*;

public interface MyService {
    void addProduct(ProductDTO productDTO);
    void addCustomer(CustomerDTO customerDTO);
    void addCategory(CategoryDTO categoryDTO);
    void addTrade(TradeDTO tradeDTO);
    void addProducer(ProducerDTO producerDTO);
    void addCustomerOrder(CustomerOrderdDTO customerOrderdDTO);
    void addShop(ShopDTO shopDTO);
    void addStock(StockDTO stockDTO);
    void addCountry(CountryDTO countryDTO);
}
