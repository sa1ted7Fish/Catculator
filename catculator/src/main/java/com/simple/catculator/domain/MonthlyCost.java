package com.simple.catculator.domain;

import java.math.BigDecimal;

public class MonthlyCost {
    public int id;
    public String productName;
    public BigDecimal unitPrice;
    public double months;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getMonths() {
        return months;
    }

    public void setMonths(double months) {
        this.months = months;
    }
}
