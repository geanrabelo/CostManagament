package com.br.CostManagement.dto.response.category;

import com.br.CostManagement.entity.Category;

public record CategoryDetailsDTO(Long id,
                                 String name,
                                 Long user_id) {
    public CategoryDetailsDTO(Category category){
        this(category.getId(), category.getName(), category.getUser().getId());
    }
}
