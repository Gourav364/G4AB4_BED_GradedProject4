package com.gl.employee.controller;

import com.gl.employee.entity.Employee;
import com.gl.employee.entity.Role;
import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final UserService userService;

    @GetMapping("/showFormForAddRole")
    public String showFormForAddRole(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "create_roles";
    }

    @PostMapping("/save")
    public String insert(@ModelAttribute Role role, Model model) throws EmployeeException {
        userService.addRole(role);
        model.addAttribute("msg", "Role " + role.getName() + " added successfully");
        return "redirect:/roles/showFormForAddRole";
    }
}
