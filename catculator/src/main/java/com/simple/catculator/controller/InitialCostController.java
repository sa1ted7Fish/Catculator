package com.simple.catculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.service.InitialCostService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/initial-cost")
public class InitialCostController {

    @Autowired
    private InitialCostService initialCostService;

    @GetMapping
    public List<InitialCost> getInitialCostList(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return initialCostService.getInitialCostList(sessionId);
    }

    @PostMapping(produces = "application/json;charset=UTF-8")
    public int addInitialCost(HttpServletRequest request, @RequestBody InitialCost initialCost) {
        String sessionId = request.getSession().getId();
        return initialCostService.addInitialCost(sessionId, initialCost);
    }

    @PutMapping(produces = "application/json;charset=UTF-8")
    public int updateInitialCost(HttpServletRequest request, @RequestBody InitialCost initialCost) {
        String sessionId = request.getSession().getId();
        return initialCostService.updateInitialCost(sessionId, initialCost);
    }

    @DeleteMapping("/{id}")
    public int deleteInitialCost(HttpServletRequest request, @PathVariable int id) {
        String sessionId = request.getSession().getId();
        return initialCostService.deleteInitialCost(sessionId, id);
    }
}
