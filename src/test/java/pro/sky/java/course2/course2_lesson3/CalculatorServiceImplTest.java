package pro.sky.java.course2.course2_lesson3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.course2_lesson3.servise.CalculatorService;
import pro.sky.java.course2.course2_lesson3.servise.CalculatorServiceImpl;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorServiceImplTest {

    private CalculatorService out;

    @BeforeEach
    public void init() {
        this.out = new CalculatorServiceImpl();
    }

    @Test
    public void testSum() {
        int result = out.sum(15, 15);
        assertEquals(30, result);
    }

    @Test
    public void testSumWithZero() {
        int result = out.sum(20, 0);
        assertEquals(20, result);
    }

    @Test
    public void testSubtract() {
        int result = out.subtract(100, 40);
        assertEquals(60, result);
    }

    @Test
    public void testSubtractionWithNegativeResult() {
        int result = out.subtract(10, 20);
        assertEquals(-10, result);
    }

    @Test
    public void testMultiply() {
        int result = out.multiply(10, 10);
        assertEquals(100, result);
    }

    @Test
    public void testMultiplyWithNegativeResult() {
        int result = out.multiply(5, -10);
        assertEquals(-50, result);
    }

    @Test
    public void testDivide() {
        int result = out.divide(45, 9);
        assertEquals(5, result);
    }

    @Test
    public void testDivideOnZero() {
        assertThrowsExactly(IllegalArgumentException.class, () -> out.divide(7, 0));
    }

    private static Stream<Arguments> sumParamsForTest() {
        return Stream.of(
                Arguments.of(10, 10, 20),
                Arguments.of(20, 150, 170),
                Arguments.of(2, 0, 2),
                Arguments.of(10, -4, 6)
        );
    }

    private static Stream<Arguments> subtractParamsForTest() {
        return Stream.of(
                Arguments.of(20, 10, 10),
                Arguments.of(170, 20, 150),
                Arguments.of(2, 0, 2),
                Arguments.of(6, 10, -4)
        );
    }

    private static Stream<Arguments> multiplyParamsForTest() {
        return Stream.of(
                Arguments.of(20, 10, 200),
                Arguments.of(15, 2, 30),
                Arguments.of(2, 0, 0),
                Arguments.of(-4, 10, -40)
        );
    }

    private static Stream<Arguments> divideParamsForTest() {
        return Stream.of(
                Arguments.of(20, 10, 2),
                Arguments.of(30, 2, 15),
                Arguments.of(0, 2, 0),
                Arguments.of(6, 10, 0)
        );
    }

        @ParameterizedTest
        @MethodSource("sumParamsForTest")
        public void testSum ( int num1, int num2, int expectedResult){
            assertEquals(expectedResult, out.sum(num1, num2));
        }

    @ParameterizedTest
    @MethodSource("subtractParamsForTest")
    public void testSubtract ( int num1, int num2, int expectedResult){
        assertEquals(expectedResult, out.subtract(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyParamsForTest")
    public void testMultiply ( int num1, int num2, int expectedResult){
        assertEquals(expectedResult, out.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divideParamsForTest")
    public void testDivide ( int num1, int num2, int expectedResult){
        assertEquals(expectedResult, out.divide(num1, num2));
    }



    }
