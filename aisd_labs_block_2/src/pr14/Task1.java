package pr14;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Ввести строку");
            System.out.println("2. Разбить по пробелам");
            System.out.println("3. Разбить по запятым");
            System.out.println("4. Разбить по цифрам");
            System.out.println("5. Разбить по знакам пунктуации");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // съесть \n после числа

            if (choice == 0) break;

            if (choice == 1) {
                System.out.print("Введите строку: ");
                text = scanner.nextLine();
                System.out.println("Сохранено: " + text);

            } else if (choice >= 2 && choice <= 5) {
                if (text.isEmpty()) {
                    System.out.println("Сначала введите строку (пункт 1)!");
                    continue;
                }

                String regex = "";
                if (choice == 2) regex = "\\s+";         // пробелы
                if (choice == 3) regex = ",";            // запятые
                if (choice == 4) regex = "\\d+";         // цифры
                if (choice == 5) regex = "[.,;:!?]";     // знаки пунктуации

                String[] parts = text.split(regex);

                System.out.println("Результат разбиения:");
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].isEmpty()) {
                        System.out.println("  [" + i + "] " + parts[i]);
                    }
                }
            }
        }

        scanner.close();
    }
}