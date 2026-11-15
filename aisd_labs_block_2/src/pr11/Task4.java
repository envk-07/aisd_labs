package pr11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите: <Год> <Месяц> <Число> <Часы> <Минуты>");
        System.out.print("> ");

        int year    = scanner.nextInt();
        int month   = scanner.nextInt();
        int day     = scanner.nextInt();
        int hours   = scanner.nextInt();
        int minutes = scanner.nextInt();


        if (year < 1900 || year > 9999) {
            System.out.println("Ошибка: год должен быть от 1900 до 9999");
            return;
        }
        if (month < 1 || month > 12) {
            System.out.println("Ошибка: месяц должен быть от 1 до 12");
            return;
        }
        if (day < 1 || day > 31) {
            System.out.println("Ошибка: число должно быть от 1 до 31");
            return;
        }
        if (hours < 0 || hours > 23) {
            System.out.println("Ошибка: часы должны быть от 0 до 23");
            return;
        }
        if (minutes < 0 || minutes > 59) {
            System.out.println("Ошибка: минуты должны быть от 0 до 59");
            return;
        }

        if (!isValidDay(year, month, day)) {
            System.out.println("Ошибка: в месяце " + month +
                    " года " + year + " нет дня " + day);
            return;
        }

        Date date = new Date(year - 1900, month - 1, day, hours, minutes);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);


        System.out.println("\nРезультат:");
        System.out.println("Date:     " + date);
        System.out.println("Calendar: " + cal.getTime());

        scanner.close();
    }

    static boolean isValidDay(int year, int month, int day) {
        Calendar test = Calendar.getInstance();
        test.setLenient(false);
        test.set(Calendar.YEAR, year);
        test.set(Calendar.MONTH, month - 1);
        test.set(Calendar.DAY_OF_MONTH, day);

        try {
            test.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}