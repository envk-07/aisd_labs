package pr14;


public class Task9 {
    public static void main(String[] args) {
        String text = "Мама мыла раму, а рама мыла маму. " +
                "Шла Саша по шоссе и сосала сушку.";

        int[] counts = new int[33];
        String textLower = text.toLowerCase();

        int[] ruCounts = new int[33];
        for (int i = 0; i < textLower.length(); i++) {
            char c = textLower.charAt(i);
            if (c == 'ё') {
                ruCounts[32]++;
            } else if (c >= 'а' && c <= 'я') {
                ruCounts[c - 'а']++;
            }
        }

        System.out.println("\nЧастотный словарь (русский):");
        for (int i = 0; i < 32; i++) {
            if (ruCounts[i] > 0) {
                char c = (char) ('а' + i);
                System.out.println("  '" + c + "' -> " + ruCounts[i]);
            }
        }
        if (ruCounts[32] > 0) {
            System.out.println("  'ё' -> " + ruCounts[32]);
        }
    }
}