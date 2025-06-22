package com.br.CostManagement.dto.response.cost;

import com.br.CostManagement.entity.Cost;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CostDetailsDTO(String description,
                             BigDecimal value,
                             LocalDate date,
                             String category,
                             String user) {
    public CostDetailsDTO(Cost cost){
        this(cost.getDescription(), cost.getValue(), cost.getDate(), cost.getCategory().getName(), cost.getUser().getName());
    }
}
