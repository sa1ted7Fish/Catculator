package com.simple.catculator.controller;

import com.simple.catculator.domain.IrregularCost;
import com.simple.catculator.service.IrregularCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/irregular-cost")
public class IrregularCostController {

    @Autowired
    private IrregularCostService irregularCostService;

    @GetMapping
    public List<IrregularCost> getIrregularCostList(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return irregularCostService.getIrregularCostList(sessionId);
    }

    @PostMapping(produces = "application/json;charset=UTF-8")
    public int addIrregularCost(HttpServletRequest request, @RequestBody IrregularCost IrregularCost) {
        String sessionId = request.getSession().getId();
        return irregularCostService.addIrregularCost(sessionId, IrregularCost);
    }

    @PutMapping(produces = "application/json;charset=UTF-8")
    public int updateIrregularCost(HttpServletRequest request, @RequestBody IrregularCost IrregularCost) {
        String sessionId = request.getSession().getId();
        return irregularCostService.updateIrregularCost(sessionId, IrregularCost);
    }

    @DeleteMapping("/{id}")
    public int deleteIrregularCost(HttpServletRequest request, @PathVariable int id) {
        String sessionId = request.getSession().getId();
        return irregularCostService.deleteIrregularCost(sessionId, id);
    }
}
