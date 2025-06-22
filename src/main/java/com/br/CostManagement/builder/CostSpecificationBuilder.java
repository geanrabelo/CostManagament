package com.br.CostManagement.builder;

import com.br.CostManagement.entity.Category;
import com.br.CostManagement.entity.Cost.CostBuilder;
import com.br.CostManagement.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CostSpecificationBuilder {

    CostBuilder id(Long id);

    CostBuilder description(String description);

    CostBuilder value(BigDecimal value);

    CostBuilder date(LocalDate date);

    CostBuilder category(Category category);

    CostBuilder user(User user);

}
