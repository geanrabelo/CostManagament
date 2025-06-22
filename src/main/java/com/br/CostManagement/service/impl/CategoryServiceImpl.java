package com.br.CostManagement.service.impl;

import com.br.CostManagement.dto.request.category.CategoryCreateDTO;
import com.br.CostManagement.dto.response.category.CategoryDetailsDTO;
import com.br.CostManagement.entity.Category;
import com.br.CostManagement.entity.User;
import com.br.CostManagement.exception.enums.EnumCode;
import com.br.CostManagement.exception.ex.CategoryConflict;
import com.br.CostManagement.exception.ex.CategoryNotFound;
import com.br.CostManagement.exception.ex.UserNotFound;
import com.br.CostManagement.repository.CategoryRepository;
import com.br.CostManagement.repository.UserRepository;
import com.br.CostManagement.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, UserRepository userRepository){
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String create(CategoryCreateDTO categoryCreateDTO) {
        if(categoryRepository.existsByName(categoryCreateDTO.name())){
            throw new CategoryConflict(EnumCode.CAT001.getMessage());
        }
        User userDatabase = userRepository.findById(categoryCreateDTO.user_id())
                .orElseThrow(() -> new UserNotFound(EnumCode.USR000.getMessage()));
        Category category = new Category.CategoryBuilder()
                .name(categoryCreateDTO.name())
                .user(userDatabase)
                .build();
        categoryRepository.save(category);
        return "Category created successfully";
    }

    @Override
    public CategoryDetailsDTO findById(Long id) {
        return new CategoryDetailsDTO(categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFound(EnumCode.CAT000.getMessage())));
    }

    @Override
    public List<CategoryDetailsDTO> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDetailsDTO::new).toList();
    }

    @Override
    public void delete(Long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }else{
            throw new CategoryNotFound(EnumCode.CAT000.getMessage());
        }
    }
}
