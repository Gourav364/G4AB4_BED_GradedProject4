package com.gl.employee.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private List<Long> roles;
}
