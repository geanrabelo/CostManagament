package com.br.CostManagement.dto.request.cost;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CostUpdateDTO(Long id,
                            BigDecimal value,
                            LocalDate date) {
}
