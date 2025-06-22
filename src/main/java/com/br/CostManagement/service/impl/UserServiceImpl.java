package com.br.CostManagement.service.impl;

import com.br.CostManagement.dto.request.user.UserAddSalaryDTO;
import com.br.CostManagement.dto.request.user.UserCreateDTO;
import com.br.CostManagement.dto.response.user.UserDetailsDTO;
import com.br.CostManagement.entity.User;
import com.br.CostManagement.exception.enums.EnumCode;
import com.br.CostManagement.exception.ex.UserNotFound;
import com.br.CostManagement.repository.UserRepository;
import com.br.CostManagement.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
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
        if(userRepository.existsById(id)){
            User userDatabase = userRepository.getReferenceById(id);
            return new UserDetailsDTO(userDatabase);
        }
        throw new UserNotFound(EnumCode.USR000.getMessage());
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
}
