package pr14;
import java.text.SimpleDateFormat;

public class Task5 {

    public static boolean isValidDate(String s) {
        // 1. Регулярка на формат: dd/mm/yyyy, год 1900–9999
        String regex = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(19\\d{2}|[2-9]\\d{3})$";
        if (!s.matches(regex)) {
            return false;
        }

        // 2. Проверка реальности даты (високосные годы и т.п.)
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] tests = {
                "29/02/2000", // true (високосный)
                "30/04/2003", // true
                "01/01/2003", // true
                "29/02/2001", // false (не високосный)
                "30-04-2003", // false (неверный разделитель)
                "1/1/1899",   // false (формат и год)
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + " -> " + isValidDate(tests[i]));
        }
    }
}