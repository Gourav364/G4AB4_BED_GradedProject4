package com.gl.employee.controller;

import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.entity.Employee;
import com.gl.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @RequestMapping("/list")
    public String employees(Model model, Principal user) {
        model.addAttribute("employees", employeeService.employeeList());
        return "employees";
    }

    @GetMapping("/showFormForAdd")
    public String newEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(Model model, @RequestParam("employeeId") Long employeeId) throws EmployeeException {
        model.addAttribute("employee", employeeService.findEmployee(employeeId));
        return "create_employee";
    }

    @GetMapping("/redirectionUrl")
    public String error(@ModelAttribute("flashAttribute") Object flashAttribute, Model model) {
        model.addAttribute("redirectionAttribute", flashAttribute);
        return "error";
    }

    @PostMapping("/save")
    public String insert(@ModelAttribute Employee employee) throws EmployeeException {
        employeeService.addEmployee(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee) throws EmployeeException {
        employeeService.updateEmployee(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") Long employeeId) throws EmployeeException {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees/list";
    }

    @RequestMapping(value = "/403")
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
              + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
              "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;
    }
}
