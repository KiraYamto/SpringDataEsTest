package org.bobo.es.repository;

import org.bobo.es.CrudRepository;
import org.bobo.es.model.ImMessage;


public interface MessageRepository extends CrudRepository<ImMessage,Long> {

    ImMessage save(ImMessage entity); //1

    ImMessage findOne(long primaryKey);       //2

    Iterable<ImMessage> findAll();          //3

    Long count();                   //4

    void delete(long entity);          //5

    boolean exists(long primaryKey);  //6
}
