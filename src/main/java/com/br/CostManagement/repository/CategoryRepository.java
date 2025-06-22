package com.br.CostManagement.repository;

import com.br.CostManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);

    @Query("select c from Category c WHERE c.user.id = ?1")
    List<Category> findByCategoryWhereUserId(Long userId);
}
