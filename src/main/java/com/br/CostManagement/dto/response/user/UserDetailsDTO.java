package com.br.CostManagement.dto.response.user;

import com.br.CostManagement.entity.User;

import java.math.BigDecimal;

public record UserDetailsDTO(Long id, String name, BigDecimal salary) {

    public UserDetailsDTO(User user){
        this(user.getId(), user.getName(), user.getSalary());
    }
}
