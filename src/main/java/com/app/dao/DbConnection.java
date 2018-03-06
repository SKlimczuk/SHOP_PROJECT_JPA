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

    public void close()
    {
        if (entityManagerFactory != null)
        {
            entityManagerFactory.close();
        }
    }
    private DbConnection() { }
}
