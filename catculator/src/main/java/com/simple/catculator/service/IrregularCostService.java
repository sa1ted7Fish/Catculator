package com.simple.catculator.service;

import com.simple.catculator.domain.IrregularCost;

import java.util.List;

public interface IrregularCostService {
    void addNewList(String sessionId);
    void removeDeprecatedList(String sessionId);
    List<IrregularCost> getIrregularCostList(String sessionId);
    int addIrregularCost(String sessionId, IrregularCost irregularCost);
    int updateIrregularCost(String sessionId, IrregularCost irregularCost);
    int deleteIrregularCost(String sessionId, int id);
}
