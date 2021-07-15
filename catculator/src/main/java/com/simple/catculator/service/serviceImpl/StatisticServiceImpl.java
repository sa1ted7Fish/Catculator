package com.simple.catculator.service.serviceImpl;

import com.simple.catculator.domain.InitialCost;
import com.simple.catculator.service.InitialCostService;
import com.simple.catculator.service.IrregularCostService;
import com.simple.catculator.service.MonthlyCostService;
import com.simple.catculator.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private InitialCostService initialCostService;

    @Autowired
    private IrregularCostService irregularCostService;

    @Autowired
    private MonthlyCostService monthlyCostService;

}
