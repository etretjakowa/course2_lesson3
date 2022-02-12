package pro.sky.java.course2.course2_lesson3.servise;

public interface CalculatorService {

    int sum(int num1, int num2);

    int subtract(int num1, int num2);

    int multiply(int num1, int num2);

    int divide(int num1, int num2) throws IllegalArgumentException;

}
