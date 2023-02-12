package com.gl.employee.service;

import com.gl.employee.entity.Employee;
import com.gl.employee.entity.Role;
import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addRole(Role role) throws EmployeeException;

    List<Role> roleList();

    void addUser(UserDto userDto);
}
