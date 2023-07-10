package lesson_4;

import java.util.ArrayDeque;
import java.util.Deque;

public class lesson_4_1 {
    public static void main(String[] args) {
        // умножение
        Deque<Integer> num1 = new ArrayDeque<>();
        num1.add(2);
        num1.add(4);
        num1.add(3); 

        Deque<Integer> num2 = new ArrayDeque<>();
        num2.add(5);
        num2.add(6);
        num2.add(4); 

        Deque<Integer> product = multiplyNumbers(num1, num2);
        System.out.println("Произведение чисел: " + product);

        // сложение
        Deque<Integer> num3 = new ArrayDeque<>();
        num3.add(-1);
        num3.add(2); 

        Deque<Integer> num4 = new ArrayDeque<>();
        num4.add(3);
        num4.add(7);
        num4.add(5); 

        Deque<Integer> sum = addNumbers(num3, num4);
        System.out.println("Сумма чисел: " + sum);
    }

    public static Deque<Integer> multiplyNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        int carry = 0;
        Deque<Integer> product = new ArrayDeque<>();

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();

            int result = digit1 * digit2 + carry;
            int digit = result % 10;
            carry = result / 10;

            product.addLast(digit);
        }

        return product;
    }

    public static Deque<Integer> addNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        int carry = 0;
        Deque<Integer> sum = new ArrayDeque<>();

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();

            int result = digit1 + digit2 + carry;
            int digit = result % 10;
            carry = result / 10;

            sum.addLast(digit);
        }

        return sum;
    }
}
