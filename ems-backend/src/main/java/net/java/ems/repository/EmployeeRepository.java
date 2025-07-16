package net.java.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.ems.entity.Employee;

/*
 * 这个repository是用来操作数据库的，继承了JpaRepository，JpaRepository是springboot的jpa库，
 * 提供了一些常用的数据库操作方法，比如save，findAll，delete等
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
