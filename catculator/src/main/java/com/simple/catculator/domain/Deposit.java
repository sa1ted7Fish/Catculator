package com.simple.catculator.domain;

import java.math.BigDecimal;

public class Deposit {
    public BigDecimal deposit;
    public BigDecimal monthlyPay;

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
}
