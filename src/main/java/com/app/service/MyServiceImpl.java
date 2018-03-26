package com.app.service;

import com.app.dao.categoryDao.CategoryDao;
import com.app.dao.categoryDao.CategoryDaoImpl;
import com.app.dao.countryDao.CountryDao;
import com.app.dao.countryDao.CountryDaoImpl;
import com.app.dao.customerDao.CustomerDao;
import com.app.dao.customerDao.CustomerDaoImpl;
import com.app.dao.customerOrderDao.CustomerOrderDao;
import com.app.dao.customerOrderDao.CustomerOrderDaoImpl;
import com.app.dao.producerDao.ProducerDao;
import com.app.dao.producerDao.ProducerDaoImpl;
import com.app.dao.productDao.ProductDao;
import com.app.dao.productDao.ProductDaoImpl;
import com.app.dao.shopDao.ShopDao;
import com.app.dao.shopDao.ShopDaoImpl;
import com.app.dao.stockDao.StockDao;
import com.app.dao.stockDao.StockDaoImpl;
import com.app.dao.tradeDao.TradeDao;
import com.app.dao.tradeDao.TradeDaoImpl;
import com.app.model.*;
import com.app.model.dto.*;

public class MyServiceImpl implements MyService {
    private ProductDao productDao = new ProductDaoImpl();
    private Validators validators = new Validators();
    private Converter converter = new Converter();
    private CustomerDao customerDao = new CustomerDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private TradeDao tradeDao = new TradeDaoImpl();
    private ProducerDao producerDao = new ProducerDaoImpl();
    private CustomerOrderDao customerOrderDao = new CustomerOrderDaoImpl();
    private ShopDao shopDao = new ShopDaoImpl();
    private StockDao stockDao = new StockDaoImpl();
    private CountryDao countryDao = new CountryDaoImpl();

    @Override
    public void addProduct(ProductDTO productDTO) {
        if (!validators.isProductDtoValid(productDTO))
            throw new IllegalArgumentException("ADD PRODUCT - PRODUCT DTO - VALIDATION ERROR");

        Product product = converter.fromProductDtoToProduct(productDTO);

        if (product == null)
            throw new NullPointerException("ADD NEW PRODUCT - PRODUCT IS NULL");

        productDao.add(product);

    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        if (!validators.isCustomerDtoValid(customerDTO))
            throw new IllegalArgumentException("ADD CUSTOMER - CUSTOMER DTO - VALIDATION ERROR");

        Customer customer = converter.fromCustomerDtoToCustomer(customerDTO);

        if(customer == null)
            throw new NullPointerException("ADD NEW CUNSOMER - CUNSOMER IS NULL");

        customerDao.add(customer);
    }

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        if(!validators.iscCategoryValid(categoryDTO))
            throw new IllegalArgumentException("ADD CATEGORY - CATEGORY DTO - VALIDATION ERROR");

        Category category = converter.fromCategoryDtoToCategory(categoryDTO);

        if(category == null)
            throw new NullPointerException("ADD MEW CATEGORY - CATEGORY IS NULL");

        categoryDao.add(category);
    }

    @Override
    public void addTrade(TradeDTO tradeDTO) {
        if(!validators.isTradeValid(tradeDTO))
            throw new IllegalArgumentException("ADD TRADE - TRADE DTO - VALIDATION ERROR");

        Trade trade = converter.fromTradeDtoToTrade(tradeDTO);

        if(trade == null)
            throw new NullPointerException("ADD NEW TRADE - TRADE IS NULL");

        tradeDao.add(trade);
    }

    @Override
    public void addProducer(ProducerDTO producerDTO) {
        if(!validators.isProducerValid(producerDTO))
            throw new IllegalArgumentException("ADD TRADE - PRODUCER DTO - VALIDATION ERROR");

        Producer producer = converter.fromProducerDtoToProducer(producerDTO);

        if(producer == null)
            throw new NullPointerException("ADD NEW PRODUCER - PRODUCER IS NULL");

        producerDao.add(producer);
    }

    @Override
    public void addCustomerOrder(CustomerOrderdDTO customerOrderdDTO) {
        if(!validators.isCustomerOrderValid(customerOrderdDTO))
            throw new IllegalArgumentException("ADD CUSTOMER - CUSTOMER ORDER DTO - VALIDATION ERROR");

        CustomerOrder customerOrder = converter.fromCustomerOrderDtoToCutomerOrder(customerOrderdDTO);

        if(customerOrder == null)
            throw new NullPointerException("ADD NEW CUSTOMER ORDER - CUSTOMER ORDER IS NULL");

        customerOrderDao.add(customerOrder);
    }

    @Override
    public void addShop(ShopDTO shopDTO) {
        if(!validators.isShopValid(shopDTO))
            throw new IllegalArgumentException("ADD SHOP - CUSTOMER SHOP DTO - VALIDATION ERROR");

        Shop shop = converter.fromShopDtoToShop(shopDTO);

        if(shopDTO == null)
            throw new NullPointerException("ADD NEW SHOP - SHOP IS NULL");

        shopDao.add(shop);
    }

    @Override
    public void addStock(StockDTO stockDTO) {
        if(!validators.isStockValid(stockDTO))
            throw new IllegalArgumentException("ADD STOCK - STOCK DTO - VALIDATION ERROR");

        Stock stock = converter.fromStockDtoToStock(stockDTO);

        if(stock == null)
            throw new NullPointerException("ADD NEW STOCK - STOCK IS NULL");

        stockDao.add(stock);
    }

    @Override
    public void addCountry(CountryDTO countryDTO) {
        if(!validators.isCountryValid(countryDTO))
            throw new IllegalArgumentException("ADD COUNTRY - COUNTRY DTO - VALIDATION ERROR");

        Country country = converter.fromCountryDtoToCountry(countryDTO);

        if(country == null)
            throw new NullPointerException("ADD NEW COUNTRY - COUNTRY IS NULL");

        countryDao.add(country);
    }


}
