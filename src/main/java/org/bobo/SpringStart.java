package org.bobo;

import org.bobo.es.model.Employee;
import org.bobo.es.repository.EmployeeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStart {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/spring-application.xml");
        EmployeeRepository employeeRepository = (EmployeeRepository)ctx.getBean("employeeRepository");
     //   Employee employee = employeeRepository.findByLastnameAndFirstname("Smith","John");
        Employee employee = employeeRepository.findOne(2L);
        System.out.println(employee.getFirstname());
    }
}
