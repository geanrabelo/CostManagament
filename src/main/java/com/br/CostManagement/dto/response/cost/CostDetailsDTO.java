package com.br.CostManagement.dto.response.cost;

import com.br.CostManagement.entity.Cost;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CostDetailsDTO(Long id,
                             String description,
                             BigDecimal value,
                             LocalDate date,
                             Long category_id,
                             Long user_id) {
    public CostDetailsDTO(Cost cost){
        this(cost.getId(), cost.getDescription(), cost.getValue(), cost.getDate(), cost.getCategory().getId(), cost.getUser().getId());
    }
}
