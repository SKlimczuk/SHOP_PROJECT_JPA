package com.app.model.dto;

import com.app.dao.categoryDao.CategoryDao;
import com.app.dao.categoryDao.CategoryDaoImpl;
import com.app.dao.countryDao.CountryDao;
import com.app.dao.countryDao.CountryDaoImpl;
import com.app.dao.customerDao.CustomerDao;
import com.app.dao.customerDao.CustomerDaoImpl;
import com.app.dao.paymentDao.PaymentDao;
import com.app.dao.paymentDao.PaymentDaoImpl;
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

import java.util.HashSet;

public class Converter {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    private ProducerDao producerDao = new ProducerDaoImpl();
    private CountryDao countryDao = new CountryDaoImpl();
    private TradeDao tradeDao = new TradeDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    private CustomerDao customerDao = new CustomerDaoImpl();
    private PaymentDao paymentDao = new PaymentDaoImpl();
    private StockDao stockDao = new StockDaoImpl();
    private ShopDao shopDao = new ShopDaoImpl();

    public ProductDTO fromProductToProductDto(Product product)
    {
        return product == null ? null : new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory() == null ? null : product.getCategory().getId(),
                product.getProducer() == null ? null : product.getProducer().getId()
        );
    }

    //operator warunkowy trojargumentowy
    //warunek ? zwracane_kiedy_prawda : zwracane_kiedy_falsz
    public Product fromProductDtoToProduct(ProductDTO productDTO)
    {
        return productDTO == null ? null : new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getCategoryId() != null ? categoryDao.getOne(productDTO.getCategoryId()).orElse(null) : null,
                productDTO.getProducerId() != null ? producerDao.getOne(productDTO.getProducerId()).orElse(null) : null,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>()
        );
    }

    public CustomerDTO fromCustomerToCustomerDto (Customer customer)
    {
        return customer == null ? null : new CustomerDTO(
                customer.getId(),
                customer.getAge(),
                customer.getName(),
                customer.getSurname(),
                customer.getCountry() == null ? null : customer.getCountry().getId()
        );
    }

    public Customer fromCustomerDtoToCustomer (CustomerDTO customerDTO)
    {
        return customerDTO == null ? null : new Customer(
                customerDTO.getId(),
                customerDTO.getAge(),
                customerDTO.getName(),
                customerDTO.getSurname(),
                customerDTO.getCountryId() != null ? countryDao.getOne(customerDTO.getCountryId()).orElse(null) : null,
                new HashSet<>()
        );
    }

    public CategoryDTO fromCategoryToCatgeryDto(Category category)
    {
        return category == null ? null : new CategoryDTO(
               category.getId(),
               category.getName()
        );
    }

    public Category fromCategoryDtoToCategory(CategoryDTO categoryDTO)
    {
        return categoryDTO == null ? null : new Category(
                categoryDTO.getId(),
                categoryDTO.getName(),
                new HashSet<>()
        );
    }

    public TradeDTO fromTradetoTradeDto(Trade trade)
    {
        return trade == null ? null : new TradeDTO(
                trade.getId(),
                trade.getName()
        );
    }

    public Trade fromTradeDtoToTrade (TradeDTO tradeDTO){
        return tradeDTO == null ? null : new Trade(
                tradeDTO.getId(),
                tradeDTO.getName(),
                new HashSet<>()
        );
    }

    public ProducerDTO fromProducerToProducerDto(Producer producer)
    {
        return producer == null ? null : new ProducerDTO(
                producer.getId(),
                producer.getName(),
                producer.getCountry() != null ? producer.getCountry().getId() : null,
                producer.getTrade() != null ? producer.getTrade().getId() : null
        );
    }

    public Producer fromProducerDtoToProducer (ProducerDTO producerDTO)
    {
        return producerDTO == null ? null : new Producer(
                producerDTO.getId(),
                producerDTO.getName(),
                producerDTO.getCountryId() != null ? countryDao.getOne(producerDTO.getCountryId()).orElse(null) : null,
                producerDTO.getTradeId() != null ? tradeDao.getOne(producerDTO.getTradeId()).orElse(null): null,
                new HashSet<>()
        );
    }

    public ShopDTO fromShopToShopDto(Shop shop)
    {
        return shop == null ? null : new ShopDTO(
                shop.getId(),
                shop.getName(),
                shop.getCountry() != null ? shop.getCountry().getId() : null
                );
    }

    public Shop fromShopDtoToShop (ShopDTO shopDTO)
    {
        return shopDTO == null ? null : new Shop(
                shopDTO.getId(),
                shopDTO.getName(),
                shopDTO.getCountryId() != null ? countryDao.getOne(shopDTO.getCountryId()).orElse(null) : null,
                new HashSet<>()
        );
    }

    public CustomerOrder fromCustomerOrderDtoToCutomerOrder (CustomerOrderdDTO customerOrderdDTO)
    {
        return
                customerOrderdDTO == null ? null : new CustomerOrder(
                customerOrderdDTO.getId(),
                customerOrderdDTO.getDate(),
                customerOrderdDTO.getDiscount(),
                customerOrderdDTO.getQunatity(),
                customerOrderdDTO.getCustomerId() != null ? customerDao.getOne(customerOrderdDTO.getCustomerId()).orElse(null) : null,
                customerOrderdDTO.getPaymentId() != null ? paymentDao.getOne(customerOrderdDTO.getPaymentId()).orElse(null) : null,
                customerOrderdDTO.getProductId() != null ? productDao.getOne(customerOrderdDTO.getProductId()).orElse(null) : null
        );
    }

    public CustomerOrderdDTO fromCustomerOrderToCutomerOrderDto (CustomerOrder customerOrder)
    {
        return
                customerOrder == null ? null : new CustomerOrderdDTO(
                        customerOrder.getId(),
                        customerOrder.getDate(),
                        customerOrder.getDiscount(),
                        customerOrder.getQuantity(),
                        customerOrder.getPayment() != null ? customerOrder.getPayment().getId() : null,
                        customerOrder.getProduct() != null ? customerOrder.getProduct().getId() : null,
                        customerOrder.getCustomer() != null ? customerOrder.getCustomer().getId() : null
                );
    }

    public Stock fromStockDtoToStock (StockDTO stockDTO)
    {
        return
                stockDTO == null ? null : new Stock(
                        stockDTO.getId(),
                        stockDTO.getQuantity(),
                        stockDTO.getProductId() != null ? productDao.getOne(stockDTO.getProductId()).orElse(null) : null,
                        stockDTO.getShopId() != null ? shopDao.getOne(stockDTO.getShopId()).orElse(null) : null
                );
    }

    public StockDTO fromStockToStockDto (Stock stock)
    {
        return
                stock == null ? null : new StockDTO(
                        stock.getId(),
                        stock.getQuantity(),
                        stock.getProduct() != null ? stock.getProduct().getId() : null,
                        stock.getShop() != null ? stock.getShop().getId() : null
                );
    }

    public Country fromCountryDtoToCountry (CountryDTO countryDTO)
    {
        return
                countryDTO == null ? null : new Country(
                        countryDTO.getId(),
                        countryDTO.getName(),
                        new HashSet<>(),
                        new HashSet<>(),
                        new HashSet<>()
                );
    }

    public CountryDTO fromCountryToCountryDto (Country country)
    {
        return
                country == null ? null : new CountryDTO(
                        country.getId(),
                        country.getName()
                );
    }
}
