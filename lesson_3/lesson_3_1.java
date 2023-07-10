package lesson_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class lesson_3_1 {
    public static void main(String[] args) {
        int length = 10; // Изначальная длина массива
        List<Integer> numbers = generateRandomNumbers(length);

        numbers.removeIf(number -> number % 2 == 0);

        int min = Collections.min(numbers);

        int max = Collections.max(numbers);

        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = sum / numbers.size();

        System.out.println("Массив после удаления чётных чисел: " + numbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }

    public static List<Integer> generateRandomNumbers(int length) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(21); // Генерация чисел от 0 до 20
            numbers.add(randomNumber);
        }

        return numbers;
    }
}