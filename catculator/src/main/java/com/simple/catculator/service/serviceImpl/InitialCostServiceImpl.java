package com.simple.catculator.service.serviceImpl;

import org.springframework.stereotype.Service;
import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.service.InitialCostService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitialCostServiceImpl implements InitialCostService {

    List<InitialCost> retList = new ArrayList<>();
    int index = 0;

    @Override
    public List<InitialCost> getInitialCostList() {
        return retList;
    }

    @Override
    public int addInitialCost(InitialCost initialCost) {
        initialCost.setId(index);
        index++;
        retList.add(initialCost);
        return 0;
    }

    @Override
    public int updateInitialCost(InitialCost initialCost) {
        for (InitialCost item: retList) {
            if (item.id == initialCost.id) {
                item.setProductName(initialCost.getProductName());
                item.setUnitPrice(initialCost.getUnitPrice());
                item.setAmount(initialCost.getAmount());
            }
        }
        return 0;
    }

    @Override
    public int deleteInitialCost(int id) {
        retList.removeIf(item -> item.id == id);
        return 0;
    }
}
