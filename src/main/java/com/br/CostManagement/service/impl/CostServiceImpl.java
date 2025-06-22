package com.br.CostManagement.service.impl;

import com.br.CostManagement.dto.request.cost.CostCreateDTO;
import com.br.CostManagement.dto.request.cost.CostUpdateDTO;
import com.br.CostManagement.dto.response.cost.CostDetailsDTO;
import com.br.CostManagement.entity.Category;
import com.br.CostManagement.entity.Cost;
import com.br.CostManagement.entity.User;
import com.br.CostManagement.exception.enums.EnumCode;
import com.br.CostManagement.exception.ex.CategoryNotFound;
import com.br.CostManagement.exception.ex.CostConflict;
import com.br.CostManagement.exception.ex.CostNotFound;
import com.br.CostManagement.exception.ex.UserNotFound;
import com.br.CostManagement.repository.CategoryRepository;
import com.br.CostManagement.repository.CostRepository;
import com.br.CostManagement.repository.UserRepository;
import com.br.CostManagement.service.CostService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CostServiceImpl implements CostService {

    private final CostRepository costRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CostServiceImpl(CostRepository costRepository, CategoryRepository categoryRepository, UserRepository userRepository){
        this.costRepository = costRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String create(CostCreateDTO costCreateDTO) {
        if(costRepository.existsByDescription(costCreateDTO.description())){
            throw new CostConflict(EnumCode.CST001.getMessage());
        }
        Category categoryDatabase = categoryRepository.findById(costCreateDTO.category_id())
                .orElseThrow(() -> new CategoryNotFound(EnumCode.CAT000.getMessage()));
        User userDatabase = userRepository.findById(costCreateDTO.user_id())
                .orElseThrow(() -> new UserNotFound(EnumCode.USR000.getMessage()));
        Cost cost = new Cost.CostBuilder()
                .description(costCreateDTO.description())
                .user(userDatabase)
                .category(categoryDatabase)
                .value(costCreateDTO.value())
                .date(costCreateDTO.date())
                .build();
        costRepository.save(cost);
        return "Cost created successfully";
    }

    @Override
    public CostDetailsDTO update(CostUpdateDTO costUpdateDTO) {
        Cost costDatabase = costRepository.findById(costUpdateDTO.id())
                .orElseThrow(() -> new CostNotFound(EnumCode.CST000.getMessage()));
        if(costUpdateDTO.value().compareTo(BigDecimal.ZERO) != 0){
            costDatabase.setValue(costUpdateDTO.value());
        }
        if(costUpdateDTO.date() != null){
            costDatabase.setDate(costUpdateDTO.date());
        }
        Cost costDatabaseUpdate = costRepository.save(costDatabase);
        return new CostDetailsDTO(costDatabaseUpdate);
    }

    @Override
    public CostDetailsDTO findById(Long id) {
        return new CostDetailsDTO(costRepository.findById(id).orElseThrow(() -> new CostNotFound(EnumCode.CST000.getMessage())));
    }

    @Override
    public List<CostDetailsDTO> findAll() {
        return costRepository.findAll().stream().map(CostDetailsDTO::new).toList();
    }

    @Override
    public void delete(Long id) {
        if(costRepository.existsById(id)){
            costRepository.deleteById(id);
        }else{
            throw new CostNotFound(EnumCode.CST000.getMessage());
        }
    }
}
