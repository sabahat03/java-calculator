package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Double> operands;

    public Calculator() {
    }

    public Double add() {
        return operands.stream().reduce((double) 0, Double::sum);
    }

    public Double subtract() {
        return operands.stream().reduce((double) 0, (a, b) -> a - b);
    }

    public Double multiply() {
        return operands.stream().reduce(1.0, (a, b) -> a * b);
    }

    public Double divide() {
        return operands.stream().reduce(1.0, (a, b) -> a / b);
    }

    public void setOperands(List<Double> operands) {
        this.operands = operands;
    }

    public List<Double> getOperands() {
        return operands;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "operands=" + operands +
                '}';
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        List<Double> operands = new ArrayList<>(2);

        System.out.print("Enter first number: ");
        operands.add(scanner.nextDouble());

        System.out.print("Enter second number: ");
        operands.add(scanner.nextDouble());

        calculator.setOperands(operands);
        System.out.println(calculator);

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = scanner.nextInt();
        if (choice < 1 || choice > 4) {
            throw new IllegalArgumentException("Invalid choice: " + choice);
        }

        double result = switch (choice) {
            case 1 -> calculator.add();
            case 2 -> calculator.subtract();
            case 3 -> calculator.multiply();
            case 4 -> calculator.divide();
            default -> throw new IllegalArgumentException("Invalid choice: " + choice);
        };

        System.out.println("Result: " + result);
    }
}