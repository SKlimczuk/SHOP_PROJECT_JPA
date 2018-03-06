package com.app.dao.producerDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.Producer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProducerDaoImpl extends AbstractGenericDao<Producer> implements ProducerDao{
}
