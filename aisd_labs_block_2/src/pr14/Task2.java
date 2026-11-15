package pr14;

public class Task2 {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";

        String s1 = "abcdefghijklmnopqrstuv18340";
        String s2 = "abcdefghijklmnoasdfasdpqrstuv18340";

        System.out.println(s1 + " -> " + s1.matches(regex)); // true
        System.out.println(s2 + " -> " + s2.matches(regex)); // false
    }
}