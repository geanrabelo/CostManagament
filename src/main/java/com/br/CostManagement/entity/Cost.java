package com.br.CostManagement.entity;

import com.br.CostManagement.builder.CostSpecificationBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_cost")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal value;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static class CostBuilder implements CostSpecificationBuilder {
        private Long id;
        private String description;
        private BigDecimal value;
        private LocalDate date;
        private Category category;
        private User user;

        public CostBuilder builder(){
            return new CostBuilder();
        }

        @Override
        public CostBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public CostBuilder description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public CostBuilder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        @Override
        public CostBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        @Override
        public CostBuilder category(Category category) {
            this.category = category;
            return this;
        }

        @Override
        public CostBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Cost build(){
            return new Cost(this.id, this.description, this.value, this.date, this.category, this.user);
        }
    }
}
