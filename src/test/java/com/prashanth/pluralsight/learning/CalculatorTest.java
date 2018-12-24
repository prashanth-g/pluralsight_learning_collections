package com.prashanth.pluralsight.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void evalute() {
        int result = calculator.evaluate("1");
        assertEquals(1,result);
    }

    @Test
    void shouldSupportAdding() {
        int result = calculator.evaluate("1 + 2");
        assertEquals(3,result);
    }

    @Test
    void shouldSupportSubtraction() {
        int result = calculator.evaluate("1 - 2");
        assertEquals(-1,result);
    }

    @Test
    void shouldDoComplexStatements() {
        int result = calculator.evaluate("1 - 5 + 2 + 4");
        assertEquals(2,result);
    }
}