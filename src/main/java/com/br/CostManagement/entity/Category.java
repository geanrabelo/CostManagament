package com.br.CostManagement.entity;

import com.br.CostManagement.builder.CategorySpecificationBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static final class CategoryBuilder implements CategorySpecificationBuilder {
        private Long id;
        private String name;
        private User user;

        public CategoryBuilder builder(){
            return new CategoryBuilder();
        }

        @Override
        public CategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public CategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public CategoryBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Category build(){
            return new Category(this.id, this.name, this.user);
        }
    }
}
