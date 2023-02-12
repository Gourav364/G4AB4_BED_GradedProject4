package com.gl.employee.controller;

import com.gl.employee.entity.Employee;
import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> delete(@PathVariable("employeeId") Long employeeId) throws EmployeeException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Deleted employee id - " + employeeId, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws EmployeeException {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> fetchById(@PathVariable("employeeId") Long employeeId) throws EmployeeException {
        return new ResponseEntity<>(employeeService.findEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping("/search/gl")
    public ResponseEntity<List<Employee>> fetchByFirstName(@RequestParam("firstName") String firstName) throws EmployeeException {
        return new ResponseEntity<>(employeeService.findEmployeeByFirstName(firstName),HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> findAllElementByOrder(@RequestParam("order") String order) throws EmployeeException {
        return new ResponseEntity<>(employeeService.findAllEmployeeByOrder(order), HttpStatus.OK);
    }
}
