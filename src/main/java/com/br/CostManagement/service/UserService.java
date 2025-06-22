package com.br.CostManagement.service;

import com.br.CostManagement.dto.request.user.UserAddSalaryDTO;
import com.br.CostManagement.dto.request.user.UserCreateDTO;
import com.br.CostManagement.dto.response.user.UserCalculateCostDTO;
import com.br.CostManagement.dto.response.user.UserDetailsDTO;

import java.util.List;

public interface UserService {

    String create(UserCreateDTO userCreateDTO);

    UserCalculateCostDTO calculateCost(Long id);

    UserDetailsDTO addSalary(UserAddSalaryDTO userAddSalaryDTO);

    UserDetailsDTO findById(Long id);

    List<UserDetailsDTO> findAll();

    void delete(Long id);
}
