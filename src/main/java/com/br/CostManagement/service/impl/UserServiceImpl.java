package com.br.CostManagement.service.impl;

import com.br.CostManagement.dto.request.user.UserAddSalaryDTO;
import com.br.CostManagement.dto.request.user.UserCreateDTO;
import com.br.CostManagement.dto.response.user.UserCalculateCostDTO;
import com.br.CostManagement.dto.response.user.UserDetailsDTO;
import com.br.CostManagement.entity.Category;
import com.br.CostManagement.entity.Cost;
import com.br.CostManagement.entity.User;
import com.br.CostManagement.exception.enums.EnumCode;
import com.br.CostManagement.exception.ex.UserNotFound;
import com.br.CostManagement.repository.CategoryRepository;
import com.br.CostManagement.repository.CostRepository;
import com.br.CostManagement.repository.UserRepository;
import com.br.CostManagement.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CostRepository costRepository;

    public UserServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, CostRepository costRepository){
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.costRepository = costRepository;
    }

    @Override
    public String create(UserCreateDTO userCreateDTO) {
        User user = new User.UserBuilder()
                .builder()
                .name(userCreateDTO.name())
                .salary(userCreateDTO.salary())
                .build();
        userRepository.save(user);
        return "User - "+user.getName()+" /// Salary - R$"+user.getSalary();
    }


    @Override
    public UserDetailsDTO addSalary(UserAddSalaryDTO userAddSalaryDTO) {
        if(userRepository.existsById(userAddSalaryDTO.id())){
            User userDatabase = userRepository.getReferenceById(userAddSalaryDTO.id());
            BigDecimal newSalary = userDatabase.getSalary().add(userAddSalaryDTO.value());
            userDatabase.setSalary(newSalary);
            User userDatabaseUpdated = userRepository.save(userDatabase);
            return new UserDetailsDTO(userDatabaseUpdated);
        }
        throw new UserNotFound(EnumCode.USR000.getMessage());
    }

    @Override
    public UserDetailsDTO findById(Long id) {
        return new UserDetailsDTO(userRepository.findById(id).orElseThrow(() -> new UserNotFound(EnumCode.USR000.getMessage())));
    }

    @Override
    public List<UserDetailsDTO> findAll() {
        return userRepository.findAll().stream().map(UserDetailsDTO::new).toList();
    }

    @Override
    public void delete(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }else{
            throw new UserNotFound(EnumCode.USR000.getMessage());
        }
    }

    @Override
    public UserCalculateCostDTO calculateCost(Long id) {
        User userDatabase = userRepository.findById(id).orElseThrow(() -> new UserNotFound(EnumCode.USR000.getMessage()));
        List<Category> categoryList = categoryRepository.findByCategoryWhereUserId(id);
        Map<Category, BigDecimal> map = categoryList.stream().collect(Collectors.toMap
                (category -> category,
                        category -> {
                            try {
                                return costRepository.findByCostWhereCategoryId(category.getId())
                                        .stream().map(Cost::getValue).reduce(BigDecimal::add).orElseThrow(Exception::new);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
        );
        BigDecimal totalCost = map.values().stream().reduce(BigDecimal::add).orElseThrow();
        BigDecimal yourMoney = userDatabase.getSalary().subtract(totalCost);
        return new UserCalculateCostDTO(userDatabase.getName(), map, totalCost, yourMoney);
    }
}
