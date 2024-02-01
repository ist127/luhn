package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LuhnAlgorithmTest {
    private static final LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm();

    @Test
    public void validateLuhnNumberWithoutCheckDigit_shouldAcceptOnlyNonEmptyStrings() {
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit(null));
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit(""));
    }

    @Test
    public void validateLuhnNumberWithoutCheckDigit_shouldAcceptCorrectLuhnNumber() {
        assertTrue(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("49927398716"));
    }

    @Test
    public void validateLuhnNumberWithoutCheckDigitr_shouldAcceptStringsWithDigitsOnly() {
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("49927E98716"));
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("-4927398716"));
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("4927398a716"));
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("4#927398716"));
    }

    @Test
    public void validateLuhnNumberWithoutCheckDigit_shouldAcceptCorrectLuhnNumberWithSpaces() {
        assertTrue(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("    499  27 398 716   "));
    }

    @Test
    public void validateLuhnNumberWithoutCheckDigit_shouldNotAcceptInvalidLuhnNumber() {
        // all single digit numbers
        for (int i=0; i<10; i++) {
            assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit(i + ""));
        }
        // all single digit numbers with spaces
        for (int i=0; i<10; i++) {
            assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit(" " + i + " "));
        }
        // incorrect luhn numbers
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("49927398717"));
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("59927398716"));
        assertFalse(luhnAlgorithm.validateLuhnNumberWithoutCheckDigit("49927298716"));
    }
}
