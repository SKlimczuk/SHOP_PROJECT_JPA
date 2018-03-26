package com.app.model.dto;

import java.math.BigDecimal;

public class Validators {

    public boolean isProductDtoValid(ProductDTO productDTO)
    {
        return
                productDTO.getName() != null && productDTO.getName().matches("[A-Z]+[ ]{0,1}[A-Z]+") &&
                productDTO.getPrice() != null && productDTO.getPrice().compareTo(BigDecimal.ZERO) >= 0;
    }

    public boolean isCustomerDtoValid(CustomerDTO customerDTO)
    {
            return
                customerDTO.getName() != null && customerDTO.getName().matches("[A-Z]+") &&
                customerDTO.getSurname() != null && customerDTO.getSurname().matches("[A-Z]+") &&
                customerDTO.getAge() != null && customerDTO.getAge() >= 18;
    }

    public boolean iscCategoryValid(CategoryDTO categoryDTO)
    {
        return categoryDTO.getName() != null && categoryDTO.getName().matches("[A-Z]+[ ]{0,1}[A-Z]+");
    }

    public boolean isTradeValid(TradeDTO tradeDTO)
    {
        return tradeDTO.getName() != null && tradeDTO.getName().matches("[A-Z]+[ ]{0,1}[A-Z]+");
    }

    public boolean isProducerValid (ProducerDTO producerDTO)
    {
        return producerDTO.getName() != null && producerDTO.getName().matches("[A-Z]+[ ]{0,1}[A-Z]+");
    }

    public boolean isShopValid (ShopDTO shopDTO)
    {
        return shopDTO.getName() != null && shopDTO.getName().matches("[A-Z]+[ ]{0,1}[A-Z]+");
    }

    public boolean isCustomerOrderValid (CustomerOrderdDTO customerOrderdDTO)
    {
        return
                customerOrderdDTO.getDiscount() != null && customerOrderdDTO.getDiscount().compareTo(BigDecimal.ZERO) >= 0 &&
                customerOrderdDTO.getDiscount() != null && customerOrderdDTO.getDiscount().compareTo(BigDecimal.ZERO) <= 1.0 &&
                customerOrderdDTO.getQunatity() != null && customerOrderdDTO.getQunatity() >= 0;
    }

    public boolean isStockValid (StockDTO stockDTO)
    {
        return stockDTO.getQuantity() != null && stockDTO.getQuantity() >= 0;
    }

    public boolean isCountryValid (CountryDTO countryDTO)
    {
        return countryDTO.getName() != null && countryDTO.getName().matches("[A-Z]+[ ]{0,1}[A-Z]+");
    }
}
