package com.br.CostManagement.builder;

import com.br.CostManagement.entity.User.UserBuilder;

import java.math.BigDecimal;

public interface UserSpecificationBuilder {

    UserBuilder id(Long id);

    UserBuilder name(String name);

    UserBuilder salary(BigDecimal salary);
}
