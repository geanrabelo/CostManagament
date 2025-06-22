package com.br.CostManagement.entity;

import com.br.CostManagement.builder.UserSpecificationBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal salary;

    public static class UserBuilder implements UserSpecificationBuilder {
        private Long id;
        private String name;
        private BigDecimal salary;

        public UserBuilder builder(){
            return new UserBuilder();
        }

        @Override
        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public UserBuilder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public User build(){
            return new User(this.id, this.name, this.salary);
        }
    }
}
