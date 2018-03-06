package com.app.dao.paymentDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PaymentDaoImpl extends AbstractGenericDao<Payment> implements PaymentDao{
}
