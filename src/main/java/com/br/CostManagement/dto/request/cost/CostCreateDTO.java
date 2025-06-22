package com.br.CostManagement.dto.request.cost;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CostCreateDTO(String description,
                            BigDecimal value,
                            @JsonFormat(pattern = "dd/MM/yyyy")
                            LocalDate date,
                            Long category_id,
                            Long user_id) {

}
