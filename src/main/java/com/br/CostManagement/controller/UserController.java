package com.br.CostManagement.controller;

import com.br.CostManagement.dto.request.user.UserAddSalaryDTO;
import com.br.CostManagement.dto.request.user.UserCreateDTO;
import com.br.CostManagement.dto.response.MessageDTO;
import com.br.CostManagement.dto.response.user.UserCalculateCostDTO;
import com.br.CostManagement.dto.response.user.UserDetailsDTO;
import com.br.CostManagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/cost/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated UserCreateDTO userCreateDTO){
        return ResponseEntity.ok(new MessageDTO(userService.create(userCreateDTO)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserDetailsDTO> addSalary(@RequestBody @Validated UserAddSalaryDTO userAddSalaryDTO){
        return ResponseEntity.ok(userService.addSalary(userAddSalaryDTO));
    }

    @GetMapping(path = "/calculate")
    public ResponseEntity<UserCalculateCostDTO> calculateCost(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(userService.calculateCost(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/id")
    public ResponseEntity<UserDetailsDTO> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
