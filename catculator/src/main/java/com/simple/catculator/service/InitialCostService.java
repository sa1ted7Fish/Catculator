package com.simple.catculator.service;

import com.simple.catculator.domain.InitialCost;

import java.util.List;
import java.util.Map;

public interface InitialCostService {
    void addNewList(String sessionId);
    void removeDeprecatedList(String sessionId);
    List<InitialCost> getInitialCostList(String sessionId);
    int addInitialCost(String sessionId, InitialCost initialCost);
    int updateInitialCost(String sessionId, InitialCost initialCost);
    int deleteInitialCost(String sessionId, int id);
}
