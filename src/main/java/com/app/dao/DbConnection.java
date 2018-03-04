package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DbConnection {
    private static DbConnection ourInstance = new DbConnection();
    public static DbConnection getInstance() {
        return ourInstance;
    }

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HIBERNATE");
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    public EntityManager getEntityManager() {
        return entityManager;
    }

    private EntityTransaction entityTransaction = entityManager.getTransaction();
    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    private DbConnection() { }
}
