package com.br.CostManagement.builder;
import com.br.CostManagement.entity.Category.CategoryBuilder;
import com.br.CostManagement.entity.User;


public interface CategorySpecificationBuilder {

    CategoryBuilder id(Long id);

    CategoryBuilder name(String name);

    CategoryBuilder user(User user);

}
