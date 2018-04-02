package org.bobo.es.repository;

import org.bobo.es.model.Employee;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Long> {

    public List<Employee> findByLastnameAndFirstname(String lastName, String firstName);
    public Employee findOne(Long id);



}