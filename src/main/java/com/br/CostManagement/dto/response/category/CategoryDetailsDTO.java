package com.br.CostManagement.dto.response.category;

import com.br.CostManagement.entity.Category;

public record CategoryDetailsDTO(String name,
                                 String user) {
    public CategoryDetailsDTO(Category category){
        this(category.getName(), category.getUser().getName());
    }
}
