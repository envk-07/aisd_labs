package pr14;

public class Task6 {

    public static boolean isValidEmail(String s) {
        // Локальная часть: буквы, цифры, точка, _, %, +, -
        // @
        // Домен: буквы, цифры, точка, -
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+$";
        return s.matches(regex);
    }

    public static void main(String[] args) {
        String[] tests = {
                "user@example.com",  // true
                "root@localhost",    // true
                "myhost@@com.ru",    // false (два @)
                "@my.ru",            // false (пустая локальная часть)
                "Julia String"       // false (нет @)
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + " -> " + isValidEmail(tests[i]));
        }
    }
}