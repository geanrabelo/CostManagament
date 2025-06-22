package com.br.CostManagement.dto.request.cost;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CostCreateDTO(String description,
                            BigDecimal value,
                            LocalDate date,
                            Long category_id,
                            Long user_id) {

}
