package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите арифметическую операцию с двумя операндами: ");
            String[] parts = scanner.nextLine().trim().split(" ");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат ввода. Ожидается: a + b, a - b, a * b или a / b");
            }

            int result = getResult(parts);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }

    private static int getResult(final String[] parts) {
        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Операнды должны быть целыми числами");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
        }

        return switch (parts[1]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Неподдерживаемая арифметическая операция");
        };
    }
}