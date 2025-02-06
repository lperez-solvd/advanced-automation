package com.solvd.methods;

public class MethodsToTest {
    private String currentMethod;
    private static final double taxRate = 0.3;

    public double getTaxRate() {
        return taxRate;
    }

    private double getTax(double basePrice) {
        return basePrice * taxRate;
    }

    public double getTotalWithTaxes(double basePrice) {
        return basePrice + getTax(basePrice);
    }

}
