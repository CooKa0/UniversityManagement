package com.solvd.laba.university.enums;

public enum Currency {
    PLN(1.0),
    USD(4.0),
    EUR(4.5);

    private final double conversionRate;

    Currency(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double convertTo(Currency targetCurrency, double amount) {
        return amount * this.conversionRate / targetCurrency.getConversionRate();
    }

    static {
        System.out.println("Supported Currencies:");
        for (Currency currency : values()) {
            System.out.println(currency.name() + ": " + currency.getConversionRate());
        }
    }
}