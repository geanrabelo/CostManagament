package com.br.CostManagement.controller;

import com.br.CostManagement.dto.request.cost.CostCreateDTO;
import com.br.CostManagement.dto.request.cost.CostUpdateDTO;
import com.br.CostManagement.dto.response.MessageDTO;
import com.br.CostManagement.dto.response.cost.CostDetailsDTO;
import com.br.CostManagement.service.CostService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/cost/cost")
public class CostController {

    private final CostService costService;

    public CostController(CostService costService){
        this.costService = costService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated CostCreateDTO costCreateDTO){
        return ResponseEntity.ok(new MessageDTO(costService.create(costCreateDTO)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CostDetailsDTO> update(@RequestBody @Validated CostUpdateDTO costUpdateDTO){
        return ResponseEntity.ok(costService.update(costUpdateDTO));
    }

    @GetMapping
    public ResponseEntity<List<CostDetailsDTO>> findAll(){
        return ResponseEntity.ok(costService.findAll());
    }

    @GetMapping(path = "/id")
    public ResponseEntity<CostDetailsDTO> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(costService.findById(id));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") Long id){
        costService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
