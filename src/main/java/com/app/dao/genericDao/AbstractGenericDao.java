package com.app.dao.genericDao;

import com.app.dao.DbConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AbstractGenericDao<T> implements GenericDao<T> {
    private final Class<T> entityClass;
    private EntityManagerFactory entityManagerFactory = DbConnection.getInstance().getEntityManagerFactory();



    public AbstractGenericDao() {
        this.entityClass
                = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public void add(T t) {
        if(entityManagerFactory != null && t != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            try {
                entityTransaction.begin();

                entityManager.persist(t);

                entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction != null)
                    entityTransaction.rollback();
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(T t) {
        if(entityManagerFactory != null && t != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            try {
                entityTransaction.begin();

                entityManager.merge(t);

                entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction != null)
                    entityTransaction.rollback();
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if(entityManagerFactory != null && id != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            try {
                entityTransaction.begin();

                T t = entityManager.find(entityClass, id);
                entityManager.remove(t);

                entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction != null)
                    entityTransaction.rollback();
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
        }
    }


    @Override
    public Optional<T> getOne(Long id) {
        if(entityManagerFactory != null && id != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            Optional<T> tOptional = null;

            if (id != null)
                try {
                    entityTransaction.begin();

                    T t = entityManager.find(entityClass, id);
                    tOptional = Optional.ofNullable(t);

                    entityTransaction.commit();
                } catch (Exception e) {
                    if (entityTransaction != null)
                        entityTransaction.rollback();
                    e.printStackTrace();
                } finally {
                    entityManager.close();
                }
            return tOptional;
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        if(entityManagerFactory != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            List<T> tList = new LinkedList<>();

            try {
                entityTransaction.begin();

                Query query = entityManager.createQuery("select from " + entityClass);
                tList = query.getResultList();

                entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction != null)
                    entityTransaction.rollback();
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
            return tList;
        }
        return null;
    }

}
