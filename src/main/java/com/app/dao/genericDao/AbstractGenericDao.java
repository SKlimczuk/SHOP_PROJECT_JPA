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
    private EntityManager entityManager = DbConnection.getInstance().getEntityManager();
    private EntityTransaction entityTransaction = DbConnection.getInstance().getEntityTransaction();


    public AbstractGenericDao() {
        this.entityClass
                = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void add(T t) {
        try
        {
            entityTransaction.begin();

            entityManager.persist(t);

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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
    }

    @Override
    public void update(T t) {
        try
        {
            entityTransaction.begin();

            //entityManager.find(t.getClass(),)

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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
    }

    @Override
    public void delete(Long id) {
        try
        {
            entityTransaction.begin();

            //T t = entityManager.find();
            //entityManager.remove(t);

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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
        }

    @Override
    public Optional<T> getOne(Long id) {
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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
        return null;
    }

}
