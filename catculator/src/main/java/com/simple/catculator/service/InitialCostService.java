package com.simple.catculator.service;

import com.simple.catculator.domain.InitialCost;

import java.util.List;
import java.util.Map;

public interface InitialCostService {
    List<InitialCost> getInitialCostList();
    int addInitialCost(InitialCost initialCost);
    int updateInitialCost(InitialCost initialCost);
    int deleteInitialCost(int id);

}
