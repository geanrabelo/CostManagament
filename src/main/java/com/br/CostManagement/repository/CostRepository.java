package com.br.CostManagement.repository;

import com.br.CostManagement.entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CostRepository extends JpaRepository<Cost, Long> {

    boolean existsByDescription(String description);

    @Query("select c from Cost c WHERE c.category.id = ?1")
    List<Cost> findByCostWhereCategoryId(Long id);
}
