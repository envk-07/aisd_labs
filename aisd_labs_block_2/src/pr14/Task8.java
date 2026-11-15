package pr14;

interface Filter {
    boolean apply(Object o);
}

public class Task8 {

    public static Object[] filter(Object[] arr, Filter f) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (f.apply(arr[i])) {
                count++;
            }
        }

        Object[] result = new Object[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (f.apply(arr[i])) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Object[] data = { "Java", "", "Python", null, "C++", "   ", "Go" };

        Filter notEmpty = new Filter() {
            public boolean apply(Object o) {
                if (o == null) return false;
                String s = (String) o;
                return s.trim().length() > 0;
            }
        };

        Object[] cleaned = filter(data, notEmpty);

        System.out.println("Результат:");
        for (int i = 0; i < cleaned.length; i++) {
            System.out.println("  " + cleaned[i]);
        }
    }
}