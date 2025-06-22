package com.br.CostManagement.repository;

import com.br.CostManagement.entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, Long> {
}
