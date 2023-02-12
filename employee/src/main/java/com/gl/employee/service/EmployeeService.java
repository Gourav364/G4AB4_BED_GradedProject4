package com.gl.employee.service;

import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> employeeList();

    Employee addEmployee(Employee employee) throws EmployeeException;

    Employee updateEmployee(Employee employee) throws EmployeeException;

    void deleteEmployee(Long id) throws EmployeeException;

    Employee findEmployee(Long id) throws EmployeeException;

    List<Employee> findEmployeeByFirstName(String firstname) throws EmployeeException;

    List<Employee> findAllEmployeeByOrder(String firstname) throws EmployeeException;
}


