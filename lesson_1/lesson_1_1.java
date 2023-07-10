import java.util.Scanner;

public class lesson_1_1 {
    public static int getNthTriangleNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число n: ");
            int n = scanner.nextInt();

            int triangleNumber = getNthTriangleNumber(n);
            System.out.println("n-е треугольное число: " + triangleNumber);

            int fact = factorial(n);
            System.out.println("Факториал числа n: " + fact);
        }
    }
}
