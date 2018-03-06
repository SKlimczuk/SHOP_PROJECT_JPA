package com.app.dao.tradeDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.Trade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TradeDaoImpl extends AbstractGenericDao<Trade> implements TradeDao {
}
