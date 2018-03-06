package com.app.dao.categoryDao;

import com.app.dao.DbConnection;
import com.app.dao.genericDao.AbstractGenericDao;
import com.app.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CategoryDaoImpl extends AbstractGenericDao<Category> implements CategoryDao {
    private EntityManagerFactory entityManagerFactory = getEntityManagerFactory();

   /* @Override
    public void delete(Long id)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try
        {
            entityTransaction.begin();

            Category category = entityManager.find(Category.class, id);
            entityManager.remove(category);

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

    }*/

    /*@Override
    public void update(Category category)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try
        {
            entityTransaction.begin();

            entityManager.merge(category);

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

    }*/

    @Override
    public Optional<Category> getOne(Long id)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Optional<Category> categoryOptional = null;
        try
        {
            entityTransaction.begin();

            Category category = entityManager.find(Category.class, id);
            categoryOptional = Optional.ofNullable(category);

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

        return categoryOptional;
    }

    @Override
    public List<Category> getAll()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        List<Category> categories = new LinkedList<>();

        try
        {
            entityTransaction.begin();

            Query query = entityManager.createQuery("select c from Category c");
            categories = query.getResultList();

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

        return categories;
    }
}
