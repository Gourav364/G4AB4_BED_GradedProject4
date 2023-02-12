package com.gl.employee.service.impl;

import com.gl.employee.entity.Role;
import com.gl.employee.entity.User;
import com.gl.employee.exceptionhandler.EmployeeException;
import com.gl.employee.model.UserDto;
import com.gl.employee.repository.RoleRepository;
import com.gl.employee.repository.UserRepository;
import com.gl.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addRole(Role role) throws EmployeeException {
        Optional<Role> existingRole = roleRepository.findByName(role.getName());
        if (existingRole.isPresent()) {
            throw new EmployeeException("Role already present in system.", HttpStatus.BAD_REQUEST);
        }
        roleRepository.save(role);
    }

    public List<Role> roleList() {
        return roleRepository.findAll();
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        Set<Role> roles = roleRepository.findAllByIdIn(userDto.getRoles());
        user.setRoles(roles);
        userRepository.save(user);
    }
}
