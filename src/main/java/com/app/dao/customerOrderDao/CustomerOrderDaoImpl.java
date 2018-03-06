package com.app.dao.customerOrderDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.CustomerOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CustomerOrderDaoImpl extends AbstractGenericDao<CustomerOrder> implements CustomerOrderDao{
}
