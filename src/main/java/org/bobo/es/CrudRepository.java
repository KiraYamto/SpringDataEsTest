package org.bobo.es;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

public interface CrudRepository<T, ID extends Serializable>
    extends Repository<T, ID> {

    <S extends T> S save(S entity); //1

    T findOne(ID primaryKey);       //2

    Iterable<T> findAll();          //3

    Long count();                   //4

    void delete(T entity);          //5

    boolean exists(ID primaryKey);  //6

}