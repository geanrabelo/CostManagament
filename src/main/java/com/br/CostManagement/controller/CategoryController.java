package com.br.CostManagement.controller;

import com.br.CostManagement.dto.request.category.CategoryCreateDTO;
import com.br.CostManagement.dto.response.MessageDTO;
import com.br.CostManagement.dto.response.category.CategoryDetailsDTO;
import com.br.CostManagement.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/cost/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated CategoryCreateDTO categoryCreateDTO){
        return ResponseEntity.ok(new MessageDTO(categoryService.create(categoryCreateDTO)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDetailsDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping(path = "/id")
    public ResponseEntity<CategoryDetailsDTO> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
