package com.br.CostManagement.service;

import com.br.CostManagement.dto.request.cost.CostCreateDTO;
import com.br.CostManagement.dto.request.cost.CostUpdateDTO;
import com.br.CostManagement.dto.response.cost.CostDetailsDTO;

import java.util.List;

public interface CostService {

    String create(CostCreateDTO costCreateDTO);

    CostDetailsDTO update(CostUpdateDTO costUpdateDTO);

    CostDetailsDTO findById(Long id);

    List<CostDetailsDTO> findAll();

    void delete(Long id);
}
