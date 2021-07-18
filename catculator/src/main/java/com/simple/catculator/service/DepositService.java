package com.simple.catculator.service;

import com.simple.catculator.domain.Deposit;
import com.simple.catculator.domain.InitialCost;

import java.util.List;

public interface DepositService {
    void addNewItem(String sessionId);
    void removeDeprecatedItem(String sessionId);
    Deposit getDeposit(String sessionId);
    int updateDeposit(String sessionId, Deposit deposit);
}
