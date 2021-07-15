package com.simple.catculator.service;


import com.simple.catculator.domain.MonthlyCost;

import java.util.List;

public interface MonthlyCostService {
    void addNewList(String sessionId);
    void removeDeprecatedList(String sessionId);
    List<MonthlyCost> getMonthlyCostList(String sessionId);
    int addMonthlyCost(String sessionId, MonthlyCost monthlyCost);
    int updateMonthlyCost(String sessionId, MonthlyCost monthlyCost);
    int deleteMonthlyCost(String sessionId, int id);
}
