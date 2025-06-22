package com.br.CostManagement.service;



import com.br.CostManagement.dto.request.category.CategoryCreateDTO;
import com.br.CostManagement.dto.response.category.CategoryDetailsDTO;

import java.util.List;

public interface CategoryService {

    String create(CategoryCreateDTO categoryCreateDTO);

    CategoryDetailsDTO findById(Long id);

    List<CategoryDetailsDTO> findAll();

    void delete(Long id);
}
