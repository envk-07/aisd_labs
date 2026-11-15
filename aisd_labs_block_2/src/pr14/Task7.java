package pr14;
public class Task7 {

    public static boolean isStrong(String s) {
        // (?=.*X) — "где-то в строке есть X"
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*_)[a-zA-Z0-9_]{8,}$";
        return s.matches(regex);
    }

    public static void main(String[] args) {
        String[] tests = {
                "F032_Password", // true
                "TrySpy1",       // false — нет '_'
                "smart_pass",    // false — нет заглавной и цифры
                "A007"           // false — короче 8
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + " -> " + isStrong(tests[i]));
        }
    }
}