package com.simple.catculator.domain;

import java.math.BigDecimal;

public class Statistic {
    public BigDecimal deposit;
    public BigDecimal monthlyPay;
    public BigDecimal initialCostSum;
    public BigDecimal irregularCostSum;
    public BigDecimal monthlyCostSum;
    public BigDecimal initialCostPercentage;
    public BigDecimal irregularCostPercentage;
    public BigDecimal monthlyCostPercentage;

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(BigDecimal monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public BigDecimal getInitialCostSum() {
        return initialCostSum;
    }

    public void setInitialCostSum(BigDecimal initialCostSum) {
        this.initialCostSum = initialCostSum;
    }

    public BigDecimal getIrregularCostSum() {
        return irregularCostSum;
    }

    public void setIrregularCostSum(BigDecimal irregularCostSum) {
        this.irregularCostSum = irregularCostSum;
    }

    public BigDecimal getMonthlyCostSum() {
        return monthlyCostSum;
    }

    public void setMonthlyCostSum(BigDecimal monthlyCostSum) {
        this.monthlyCostSum = monthlyCostSum;
    }

    public BigDecimal getInitialCostPercentage() {
        return initialCostPercentage;
    }

    public void setInitialCostPercentage(BigDecimal initialCostPercentage) {
        this.initialCostPercentage = initialCostPercentage;
    }

    public BigDecimal getIrregularCostPercentage() {
        return irregularCostPercentage;
    }

    public void setIrregularCostPercentage(BigDecimal irregularCostPercentage) {
        this.irregularCostPercentage = irregularCostPercentage;
    }

    public BigDecimal getMonthlyCostPercentage() {
        return monthlyCostPercentage;
    }

    public void setMonthlyCostPercentage(BigDecimal monthlyCostPercentage) {
        this.monthlyCostPercentage = monthlyCostPercentage;
    }
}
