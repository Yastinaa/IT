import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите операцию (сложение, вычитание, умножение или деление) и два числа, например: (2 + 3) или «завершить» для выхода:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("завершить")) {
                System.out.println("Выход из программы");
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Бугагашенька! Ввод должен быть в виде «a + b»");
                throw new IllegalArgumentException("Некорректный ввод!"); // формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
            } int num1 = 0;
            int num2 = 0;
            try {
                num1 = Integer.parseInt(parts[0]);
                num2 = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Бугагашенька! Калькулятор умеет работать только с целыми числами.");
                throw new IllegalArgumentException("Некорректный ввод математической операции!"); // т.к. строка не является математической операцией
            }
            if (num1 < 1 || num1 > 10) {
                System.out.println("Бугагашенька! Первое число должно быть от 1 до 10, включительно");
                throw new IllegalArgumentException("Некорректный ввод: первое число выходит за пределы диапазона (1-10)!");
            }
            if (num2 < 1 || num2 > 10) {
                System.out.println("Бугагашенька! Второе число должно быть от 1 до 10, включительно");
                throw new IllegalArgumentException("Некорректный ввод: второе число выходит за пределы диапазона (1-10)!");
            }
            switch (parts[1]) {
                case "+":
                    System.out.println("Результат: " + (num1 + num2));
                    break;
                case "-":
                    System.out.println("Результат: " + (num1 - num2));
                    break;
                case "*":
                    System.out.println("Результат: " + (num1 * num2));
                    break;
                case "/":
                        System.out.println("Результат: " + (num1 / num2));
                    break;
                default:
                    System.out.println("Бугагашенька! Неизвестная операция: " + parts[1]);
                    throw new IllegalArgumentException("Неизвестная математическая операция!");
            }
        }
    }
}