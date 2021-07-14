package com.simple.catculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.service.InitialCostService;

import java.util.List;

@RestController
@RequestMapping("/initial-cost")
public class InitialCostController {
    @Autowired
    private InitialCostService initialCostService;

    @GetMapping
    public List<InitialCost> getInitialCostList() {
        return initialCostService.getInitialCostList();
    }

    @PostMapping(produces = "application/json;charset=UTF-8")
    public int addInitialCost(@RequestBody InitialCost initialCost) {
        return initialCostService.addInitialCost(initialCost);
    }

    @PutMapping(produces = "application/json;charset=UTF-8")
    public int updateInitialCost(@RequestBody InitialCost initialCost) {
        return initialCostService.updateInitialCost(initialCost);
    }

    @DeleteMapping("/{id}")
    public int deleteInitialCost(@PathVariable int id) {
        return initialCostService.deleteInitialCost(id);
    }
}
