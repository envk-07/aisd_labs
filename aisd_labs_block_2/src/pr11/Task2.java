package pr11;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        sdf.setLenient(false); // запрещаем "мягкие" даты типа 32.13.2026

        Date now = new Date();
        System.out.println("Текущая дата и время: " + sdf.format(now));

        System.out.print("Введите дату и время (dd.MM.yyyy HH:mm): ");
        String input = scanner.nextLine();

        try {
            Date userDate = sdf.parse(input);

            if (userDate.after(now)) {
                System.out.println("Введённая дата ПОЗЖЕ текущей");
            } else if (userDate.before(now)) {
                System.out.println("Введённая дата РАНЬШЕ текущей");
            } else {
                System.out.println("Даты совпадают");
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты!");
        }

        scanner.close();
    }
}