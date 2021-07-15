package com.simple.catculator.service.serviceImpl;

import com.simple.catculator.domain.IrregularCost;
import com.simple.catculator.service.IrregularCostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IrregularCostServiceImpl implements IrregularCostService {
    Map<String, List<IrregularCost>> irregularCostMap = new HashMap<>();
    Map<String, Integer> irregularCostIndexMap = new HashMap<>();

    @Override
    public void addNewList(String sessionId) {
        int index = 0;
        List<IrregularCost> irregularCostList = new ArrayList<>();
        irregularCostMap.put(sessionId, irregularCostList);
        irregularCostIndexMap.put(sessionId, index);
    }

    @Override
    public void removeDeprecatedList(String sessionId) {
        irregularCostMap.remove(sessionId);
    }

    @Override
    public List<IrregularCost> getIrregularCostList(String sessionId) {
        return irregularCostMap.get(sessionId);
    }

    @Override
    public int addIrregularCost(String sessionId, IrregularCost irregularCost) {
        int tmpIndex = irregularCostIndexMap.get(sessionId);
        List<IrregularCost> tmpList = irregularCostMap.get(sessionId);

        irregularCost.setId(tmpIndex);
        irregularCostIndexMap.put(sessionId, ++tmpIndex);

        tmpList.add(irregularCost);
        irregularCostMap.put(sessionId, tmpList);

        return 0;
    }

    @Override
    public int updateIrregularCost(String sessionId, IrregularCost irregularCost) {
        List<IrregularCost> tmpList = irregularCostMap.get(sessionId);

        for (IrregularCost item: tmpList) {
            if (item.id == irregularCost.id) {
                item.setProductName(irregularCost.getProductName());
                item.setUnitPrice(irregularCost.getUnitPrice());
                item.setAmount(irregularCost.getAmount());
            }
        }
        return 0;
    }

    @Override
    public int deleteIrregularCost(String sessionId, int id) {
        List<IrregularCost> tmpList = irregularCostMap.get(sessionId);

        tmpList.removeIf(item -> item.id == id);
        return 0;
    }
}
