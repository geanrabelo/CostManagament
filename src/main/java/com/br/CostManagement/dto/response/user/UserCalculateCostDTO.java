package com.br.CostManagement.dto.response.user;

import com.br.CostManagement.entity.Category;

import java.math.BigDecimal;
import java.util.Map;

public record UserCalculateCostDTO(String name,
                                   Map<Category, BigDecimal> map,
                                   BigDecimal totalCost)
{
}
