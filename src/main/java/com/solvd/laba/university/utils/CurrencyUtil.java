package com.solvd.laba.university.utils;

import com.solvd.laba.university.enums.Currency;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurrencyUtil {

    // Lambda for converting currency
    public static BiFunction<Double, Currency, Double> convertToCurrency = (amount, currency) -> {
        return Currency.PLN.convertTo(currency, amount);
    };
    

    // Custom lambda function with generics for logging
    public static <T> void logCurrencyConversion(T amount, Currency from, Currency to) {
        System.out.println("Converting " + amount + " " + from + " to " + to);
    }

    // Custom lambda function for formatting currency conversions
    public static <T> Function<T, String> customFormatter() {
        return (input) -> "Formatted: " + input.toString();
    }
}
