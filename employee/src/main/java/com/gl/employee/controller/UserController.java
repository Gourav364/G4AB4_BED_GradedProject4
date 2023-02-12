package com.gl.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.model.UserDto;
import com.gl.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final ObjectMapper objectMapper;

    @GetMapping("/showFormForAddUser")
    public String showFormForAddRole(Model model) {
        UserDto user = new UserDto();

        model.addAttribute("user", user);
        model.addAttribute("roleList",  userService.roleList());
        return "create_users";
    }
    @PostMapping("/save")
    public String insert(@ModelAttribute UserDto userDto) throws EmployeeException {
        userService.addUser(userDto);
        return "redirect:/users/showFormForAddUser";
    }
}
