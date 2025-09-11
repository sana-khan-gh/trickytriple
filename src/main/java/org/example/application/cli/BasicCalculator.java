package org.example.application.cli;

/**
 * A simple command-line basic calculator that supports addition, subtraction,
 * multiplication, and division operations.
 */
public class BasicCalculator {

    /**
     * Performs a calculation on two numbers based on the specified operation.
     *
     * @param a         the first operand
     * @param b         the second operand
     * @param operation the operation to perform: "add", "subtract", "multiply", or "divide"
     * @return the result of the calculation
     * @throws ArithmeticException      if division by zero occurs
     * @throws IllegalArgumentException if the operation is invalid
     */
    public static double calculate(double a, double b, String operation) {
        switch (operation.toLowerCase()) {
            case "add":
                return a + b;
            case "subtract":
                return a - b;
            case "multiply":
                return a * b;
            case "divide":
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    /**
     * Runs the calculator in interactive command-line mode.
     * Prompts the user for input and displays results until the user exits.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            double a, b;
            while (true) {
                System.out.print("Enter first number (or 'exit' to quit): ");
                String inputA = scanner.nextLine();
                if (inputA.equalsIgnoreCase("exit")) {
                    scanner.close();
                    return;
                }
                try {
                    a = Double.parseDouble(inputA);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }

            while (true) {
                System.out.print("Enter second number: ");
                String inputB = scanner.nextLine();
                try {
                    b = Double.parseDouble(inputB);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }

            System.out.print("Enter operation (add, subtract, multiply, divide): ");
            String operation = scanner.nextLine();

            try {
                double result = calculate(a, b, operation);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}