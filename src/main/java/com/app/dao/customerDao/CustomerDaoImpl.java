package com.app.dao.customerDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CustomerDaoImpl extends AbstractGenericDao<Customer> implements CustomerDao{
}
