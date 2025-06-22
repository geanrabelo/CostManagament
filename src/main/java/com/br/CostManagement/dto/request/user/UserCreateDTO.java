package com.br.CostManagement.dto.request.user;

import java.math.BigDecimal;

public record UserCreateDTO(String name, BigDecimal salary) {
}
