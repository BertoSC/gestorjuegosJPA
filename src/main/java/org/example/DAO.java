package org.example;

import java.util.List;

public interface DAO <T>{

    T get (Integer id);

    List<T> getAll();

    T getByName(String name);

    void save(T t);

    void update(T t);

    void delete(T t);

    public void deleteById(long id);

    public List<Long> getAllIds();

    void deleteAll();

}
