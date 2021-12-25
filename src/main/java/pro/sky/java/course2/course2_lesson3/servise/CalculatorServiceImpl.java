package pro.sky.java.course2.course2_lesson3.servise;

import org.springframework.stereotype.Service;

@Service

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;


    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;


    }

    @Override
    public int divide(int num1, int num2) {
        return num1 / num2;


    }

}
