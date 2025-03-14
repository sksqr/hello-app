package com.example.hello_app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }


    @Test
    public void testAdd(){
        Integer a = 9;
        Integer b = 10;
        Integer expected = 19;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }

    @Test
    public void testAddNegative(){
        Integer a = -8;
        Integer b = -2;
        Integer expected = -10;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }

    @Test
    public void testMultiply(){
        Integer a = 9;
        Integer b = 10;
        Integer expected = 90;
        assertThat(calculator.multiply(a,b)).isEqualTo(expected);
    }


}
