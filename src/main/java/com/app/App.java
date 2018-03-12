package com.app;

import com.app.dao.DbConnection;
import com.app.dao.categoryDao.CategoryDao;
import com.app.dao.categoryDao.CategoryDaoImpl;
import com.app.model.Category;
import com.app.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class App
{
    public static void main( String[] args ) {
        //---------------------1st of testing generic dao
        CategoryDao categoryDao = new CategoryDaoImpl();
        //Category category = new Category("toy");

        //add operation success
        //categoryDao.add(category);

        //update operation fail
       /* Category category = categoryDao.getOne(2L).orElseThrow(NullPointerException::new);
        System.out.println(category);
        category.setName("spozywcze");
        categoryDao.update(category);
*/
        //delete operation success
        //categoryDao.delete(2L);

        //get one operation success
        //System.out.println(categoryDao.getOne(2L));

        //get all operation success
        System.out.println(categoryDao.getAll());
        //---------------------

        DbConnection.getInstance().close();
    }
}
