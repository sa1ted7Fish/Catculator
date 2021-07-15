package com.simple.catculator.controller;

import com.simple.catculator.domain.MonthlyCost;
import com.simple.catculator.service.MonthlyCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/monthly-cost")
public class MonthlyCostController {

    @Autowired
    private MonthlyCostService monthlyCostService;

    @GetMapping
    public List<MonthlyCost> getMonthlyCostList(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return monthlyCostService.getMonthlyCostList(sessionId);
    }

    @PostMapping(produces = "application/json;charset=UTF-8")
    public int addMonthlyCost(HttpServletRequest request, @RequestBody MonthlyCost monthlyCost) {
        String sessionId = request.getSession().getId();
        return monthlyCostService.addMonthlyCost(sessionId, monthlyCost);
    }

    @PutMapping(produces = "application/json;charset=UTF-8")
    public int updateMonthlyCost(HttpServletRequest request, @RequestBody MonthlyCost monthlyCost) {
        String sessionId = request.getSession().getId();
        return monthlyCostService.updateMonthlyCost(sessionId, monthlyCost);
    }

    @DeleteMapping("/{id}")
    public int deleteMonthlyCost(HttpServletRequest request, @PathVariable int id) {
        String sessionId = request.getSession().getId();
        return monthlyCostService.deleteMonthlyCost(sessionId, id);
    }
}
