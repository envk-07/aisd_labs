package pr14;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String text = "Товар стоит 25.98 USD, другой — 100 RUB, третий — 44 ERR, " +
                "четвёртый — 0.004 EU, пятый — 1.5 EU, шестой — 99.99 RUB.";

        // Цена: число с точкой (или без), пробел, одна из трёх валют
        String regex = "\\d+(\\.\\d+)?\\s+(USD|RUB|EU)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        System.out.println("Найденные цены:");
        while (m.find()) {
            System.out.println("  " + m.group());
        }
    }
}