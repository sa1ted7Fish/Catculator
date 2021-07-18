package com.simple.catculator.service.serviceImpl;

import com.simple.catculator.domain.*;
import com.simple.catculator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private InitialCostService initialCostService;

    @Autowired
    private IrregularCostService irregularCostService;

    @Autowired
    private MonthlyCostService monthlyCostService;

    @Autowired
    private DepositService depositService;

    @Override
    public Statistic getStatistic(String sessionId) {
        List<InitialCost> initialCostList = initialCostService.getInitialCostList(sessionId);
        List<IrregularCost> irregularCostList = irregularCostService.getIrregularCostList(sessionId);
        List<MonthlyCost> monthlyCostList = monthlyCostService.getMonthlyCostList(sessionId);
        Deposit deposit = depositService.getDeposit(sessionId);
        Statistic statistic = new Statistic();
        BigDecimal initialCostSum = new BigDecimal(String.valueOf("0"));
        BigDecimal irregularCostSum = new BigDecimal(String.valueOf("0"));
        BigDecimal monthlyCostSum = new BigDecimal(String.valueOf("0"));
        BigDecimal initialCostPercentage = new BigDecimal(String.valueOf("0"));
        BigDecimal irregularCostPercentage = new BigDecimal(String.valueOf("0"));
        BigDecimal monthlyCostPercentage = new BigDecimal(String.valueOf("0"));

        for (InitialCost item : initialCostList) {
            initialCostSum = initialCostSum.add(item.getUnitPrice().multiply(new BigDecimal(String.valueOf(item.getAmount()))));
        }

        for (IrregularCost item : irregularCostList) {
            irregularCostSum = irregularCostSum.add(item.getUnitPrice().multiply(new BigDecimal(String.valueOf(item.getAmount()))));
        }

        for (MonthlyCost item : monthlyCostList) {
            monthlyCostSum = monthlyCostSum.add(item.getUnitPrice().divide(new BigDecimal(String.valueOf(item.getMonths())), 2, RoundingMode.HALF_UP));
        }

        initialCostPercentage = (initialCostSum.divide(deposit.getDeposit(), 4, RoundingMode.HALF_UP)).multiply(new BigDecimal("100"));
        irregularCostPercentage = (irregularCostSum.divide(deposit.getDeposit(), 4, RoundingMode.HALF_UP)).multiply(new BigDecimal("100"));
        monthlyCostPercentage = (monthlyCostSum.divide(deposit.getMonthlyPay(), 4, RoundingMode.HALF_UP)).multiply(new BigDecimal("100"));

        statistic.setDeposit(deposit.deposit);
        statistic.setMonthlyPay(deposit.monthlyPay);
        statistic.setInitialCostSum(initialCostSum);
        statistic.setIrregularCostSum(irregularCostSum);
        statistic.setMonthlyCostSum(monthlyCostSum);
        statistic.setInitialCostPercentage(initialCostPercentage);
        statistic.setIrregularCostPercentage(irregularCostPercentage);
        statistic.setMonthlyCostPercentage(monthlyCostPercentage);

        return statistic;
    }
}
