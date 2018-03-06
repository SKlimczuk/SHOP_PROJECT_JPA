package com.app.dao.stockDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.Stock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class StockDaoImpl extends AbstractGenericDao<Stock> implements StockDao {
}
