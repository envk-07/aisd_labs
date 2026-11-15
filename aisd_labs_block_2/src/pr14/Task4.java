package pr14;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        String s1 = "(1 + 8) – 9 / 4";
        String s2 = "6 / 5 – 2 * 9";

        // \d+ — число
        // (?!\s*\+) — "не следует за ним (возможно с пробелами) плюс"
        String regex = "\\d+(?!\\s*\\+)";

        Pattern p = Pattern.compile(regex);

        System.out.println("Правильное выражение: " + s1);
        Matcher m1 = p.matcher(s1);
        while (m1.find()) {
            System.out.println("  цифра без '+' после: " + m1.group());
        }

        System.out.println("\nНеправильное выражение: " + s2);
        Matcher m2 = p.matcher(s2);
        while (m2.find()) {
            System.out.println("  цифра без '+' после: " + m2.group());
        }
    }
}