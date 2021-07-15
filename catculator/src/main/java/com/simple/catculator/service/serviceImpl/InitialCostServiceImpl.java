package com.simple.catculator.service.serviceImpl;

import org.springframework.stereotype.Service;
import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.service.InitialCostService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InitialCostServiceImpl implements InitialCostService {

    Map<String, List<InitialCost>> initialCostMap = new HashMap<>();
    Map<String, Integer> initialCostIndexMap = new HashMap<>();

    @Override
    public void addNewList(String sessionId) {
        int index = 0;
        List<InitialCost> initialCostList = new ArrayList<>();
        initialCostMap.put(sessionId, initialCostList);
        initialCostIndexMap.put(sessionId, index);
    }

    @Override
    public void removeDeprecatedList(String sessionId) {
        initialCostMap.remove(sessionId);
    }

    @Override
    public List<InitialCost> getInitialCostList(String sessionId) {
        return initialCostMap.get(sessionId);
    }

    @Override
    public int addInitialCost(String sessionId, InitialCost initialCost) {
        int tmpIndex = initialCostIndexMap.get(sessionId);
        List<InitialCost> tmpList = initialCostMap.get(sessionId);

        initialCost.setId(tmpIndex);
        initialCostIndexMap.put(sessionId, ++tmpIndex);

        tmpList.add(initialCost);
        initialCostMap.put(sessionId, tmpList);

        return 0;
    }

    @Override
    public int updateInitialCost(String sessionId, InitialCost initialCost) {
        List<InitialCost> tmpList = initialCostMap.get(sessionId);

        for (InitialCost item: tmpList) {
            if (item.id == initialCost.id) {
                item.setProductName(initialCost.getProductName());
                item.setUnitPrice(initialCost.getUnitPrice());
                item.setAmount(initialCost.getAmount());
            }
        }
        return 0;
    }

    @Override
    public int deleteInitialCost(String sessionId, int id) {
        List<InitialCost> tmpList = initialCostMap.get(sessionId);

        tmpList.removeIf(item -> item.id == id);
        return 0;
    }
}
