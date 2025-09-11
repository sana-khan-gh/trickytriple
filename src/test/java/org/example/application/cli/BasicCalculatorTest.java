package org.example.application.cli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    @Test
    void testAddition() {
        assertEquals(5.0, BasicCalculator.calculate(2, 3, "add"));
    }

    @Test
    void testSubtraction() {
        assertEquals(-1.0, BasicCalculator.calculate(2, 3, "subtract"));
    }

    @Test
    void testMultiplication() {
        assertEquals(6.0, BasicCalculator.calculate(2, 3, "multiply"));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, BasicCalculator.calculate(6, 3, "divide"));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
            BasicCalculator.calculate(1, 0, "divide")
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testInvalidOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            BasicCalculator.calculate(1, 2, "modulo")
        );
        assertTrue(exception.getMessage().contains("Invalid operation"));
    }
}