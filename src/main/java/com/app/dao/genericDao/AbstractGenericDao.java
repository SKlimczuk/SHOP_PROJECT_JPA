package com.app.dao.genericDao;

import com.app.dao.DbConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;
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

    @Override
    public void update(T t) {
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

    @Override
    public void delete(Long id) {
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


    @Override
    public Optional<T> getOne(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        if(id != null)
            try
            {
                entityTransaction.begin();

                //Query query = entityManager.createQuery("select t from T t where t.id = :id");

                entityTransaction.commit();
            }
            catch (Exception e)
            {
                if(entityTransaction != null)
                    entityTransaction.rollback();
                e.printStackTrace();
            }
            finally {
                entityManager.close();
            }


        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try
        {
            entityTransaction.begin();

            //Query query = entityManager.createQuery("select t from T t");

            entityTransaction.commit();
        }
        catch (Exception e)
        {
            if(entityTransaction != null)
                entityTransaction.rollback();
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }


        return null;
    }

}
