package com.simple.catculator.controller;

import com.simple.catculator.domain.Deposit;
import com.simple.catculator.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PutMapping(produces = "application/json;charset=UTF-8")
    public int updateInitialCost(HttpServletRequest request, @RequestBody Deposit deposit) {
        String sessionId = request.getSession().getId();
        return depositService.updateDeposit(sessionId, deposit);
    }
}
