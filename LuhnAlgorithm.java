package com.example;

public class LuhnAlgorithm {

    private static final int MINIMAL_LUHN_NUMBER_LENGTH = 2;

    public boolean validateLuhnNumberWithoutCheckDigit(String luhnNumber) {
        if (luhnNumber == null || luhnNumber.length() < MINIMAL_LUHN_NUMBER_LENGTH) {
            return false;
        }
        int sum = 0, digits = 0;
        boolean second = false;
        for (int i = luhnNumber.length() - 1; i >= 0; i--) {
            char c = luhnNumber.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (!isDigit(c)) {
                return false;
            }
            digits++;
            int d = c - '0';
            if (second) {
                d *= 2;
            }
            sum += d % 10;
            sum += d / 10;
            second = !second;
        }
        return digits >= MINIMAL_LUHN_NUMBER_LENGTH && (sum % 10 == 0);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
