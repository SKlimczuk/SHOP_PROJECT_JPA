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
    private EntityManagerFactory entityManagerFactory = DbConnection.getInstance().getEntityManagerFactory();
    private EntityManager entityManager = DbConnection.getInstance().getEntityManager();
    private EntityTransaction entityTransaction = DbConnection.getInstance().getEntityTransaction();

    @Override
    public void delete(Long id)
    {
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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
    }

    @Override
    public void update(Category category)
    {
        try
        {
            entityTransaction.begin();


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
    public Optional<Category> getOne(Long id)
    {
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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
        return categoryOptional;
    }

    @Override
    public List<Category> getAll()
    {
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

        if(entityManagerFactory != null)
            entityManagerFactory.close();
        return categories;
    }
}
