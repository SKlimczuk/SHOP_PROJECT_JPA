package com.app.dao.genericDao;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    //standard operations
    void add(T t);
    void update(T t);
    void delete(Long id);
    Optional<T> getOne(Long id);
    Optional<T> getByNameSurnameCountry(String name, String surname, Long countryI);
    List<T> getAll();
}
