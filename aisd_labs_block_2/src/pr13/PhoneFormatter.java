package pr13;

public class PhoneFormatter {

    public static String formatPhone(String phone) {
        // Убираем всё лишнее
        String clean = phone.replace("+", "").replace(" ", "").replace("-", "");

        // Если начинается с 8 — меняем на 7 (Россия)
        if (clean.startsWith("8")) {
            clean = "7" + clean.substring(1);
        }

        // Последние 10 цифр — это номер
        String number = clean.substring(clean.length() - 10);
        // Всё, что до них — код страны
        String code = clean.substring(0, clean.length() - 10);

        // Собираем: +<Код><3>-<3>-<4>
        String formatted = "+" + code +
                number.substring(0, 3) + "-" +
                number.substring(3, 6) + "-" +
                number.substring(6);

        return formatted;
    }

    public static void main(String[] args) {
        System.out.println(formatPhone("+79175655655"));    // +7917-565-5655
        System.out.println(formatPhone("89175655655"));     // +7917-565-5655
        System.out.println(formatPhone("+104289652211"));   // +1042-896-5221
    }
}