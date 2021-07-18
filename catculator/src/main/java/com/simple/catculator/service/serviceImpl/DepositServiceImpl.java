package com.simple.catculator.service.serviceImpl;

import com.simple.catculator.domain.Deposit;
import com.simple.catculator.service.DepositService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class DepositServiceImpl implements DepositService {
    Map<String, Deposit> depositMap = new HashMap<>();
    Map<String, Integer> depositIndexMap = new HashMap<>();

    @Override
    public void addNewItem(String sessionId) {
        int index = 0;
        Deposit deposit = new Deposit();
        deposit.setDeposit(new BigDecimal(String.valueOf("1")));
        deposit.setMonthlyPay(new BigDecimal(String.valueOf("1")));
        depositMap.put(sessionId, deposit);
        depositIndexMap.put(sessionId, index);
    }

    @Override
    public void removeDeprecatedItem(String sessionId) {
        depositMap.remove(sessionId);
        depositIndexMap.remove(sessionId);
    }

    @Override
    public Deposit getDeposit(String sessionId) {
        return depositMap.get(sessionId);
    }

    @Override
    public int updateDeposit(String sessionId, Deposit deposit) {
        depositMap.put(sessionId, deposit);
        return 0;
    }

}
