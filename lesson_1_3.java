import java.util.Scanner;

public class lesson_1_3 {
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Выберите действие:");
                System.out.println("1 - Сложение");
                System.out.println("2 - Вычитание");
                System.out.println("3 - Деление");
                System.out.println("4 - Умножение");
   
                int choice = scanner.nextInt();
   
                System.out.print("Введите первое число: ");
                double num1 = scanner.nextDouble();
   
                System.out.print("Введите второе число: ");
                double num2 = scanner.nextDouble();
   
                double result = 0;
   
                switch (choice) {
                    case 1:
                        result = num1 + num2;
                        break;
                    case 2:
                        result = num1 - num2;
                        break;
                    case 3:
                        result = num1 / num2;
                        break;
                    case 4:
                        result = num1 * num2;
                        break;
                    default:
                        System.out.println("Неверный выбор действия.");
                }
   
                System.out.println("Результат: " + result);
            }
        }
}
