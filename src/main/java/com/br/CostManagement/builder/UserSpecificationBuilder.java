package com.br.CostManagement.builder;

import com.br.CostManagement.entity.User;

import java.math.BigDecimal;

public interface UserSpecificationBuilder {

    User.UserBuilder id(Long id);

    User.UserBuilder name(String name);

    User.UserBuilder salary(BigDecimal salary);
}
