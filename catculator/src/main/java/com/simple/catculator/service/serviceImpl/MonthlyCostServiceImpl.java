package com.simple.catculator.service.serviceImpl;

import com.simple.catculator.domain.MonthlyCost;
import com.simple.catculator.service.MonthlyCostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MonthlyCostServiceImpl implements MonthlyCostService {
    Map<String, List<MonthlyCost>> monthlyCostMap = new HashMap<>();
    Map<String, Integer> monthlyCostIndexMap = new HashMap<>();

    @Override
    public void addNewList(String sessionId) {
        int index = 0;
        List<MonthlyCost> monthlyCostList = new ArrayList<>();
        monthlyCostMap.put(sessionId, monthlyCostList);
        monthlyCostIndexMap.put(sessionId, index);
    }

    @Override
    public void removeDeprecatedList(String sessionId) {
        monthlyCostMap.remove(sessionId);
        monthlyCostIndexMap.remove(sessionId);
    }

    @Override
    public List<MonthlyCost> getMonthlyCostList(String sessionId) {
        return monthlyCostMap.get(sessionId);
    }

    @Override
    public int addMonthlyCost(String sessionId, MonthlyCost monthlyCost) {
        int tmpIndex = monthlyCostIndexMap.get(sessionId);
        List<MonthlyCost> tmpList = monthlyCostMap.get(sessionId);

        monthlyCost.setId(tmpIndex);
        monthlyCostIndexMap.put(sessionId, ++tmpIndex);

        tmpList.add(monthlyCost);
        monthlyCostMap.put(sessionId, tmpList);

        return 0;
    }

    @Override
    public int updateMonthlyCost(String sessionId, MonthlyCost monthlyCost) {
        List<MonthlyCost> tmpList = monthlyCostMap.get(sessionId);

        for (MonthlyCost item: tmpList) {
            if (item.id == monthlyCost.id) {
                item.setProductName(monthlyCost.getProductName());
                item.setUnitPrice(monthlyCost.getUnitPrice());
                item.setMonths(monthlyCost.getMonths());
            }
        }
        return 0;
    }

    @Override
    public int deleteMonthlyCost(String sessionId, int id) {
        List<MonthlyCost> tmpList = monthlyCostMap.get(sessionId);

        tmpList.removeIf(item -> item.id == id);
        return 0;
    }
}
