package com.br.CostManagement.builder;

import java.math.BigDecimal;

public interface UserSpecificationBuilder {

    UserSpecificationBuilder name(String name);

    UserSpecificationBuilder salary(BigDecimal salary);
}
