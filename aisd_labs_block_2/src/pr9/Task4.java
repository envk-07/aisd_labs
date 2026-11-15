package pr9;

public class Task4 {
    public static void main(String[] args) {
        Student s1 = new Student("Вася", 105, 4.0);
        Student s2 = new Student("Петя", 102, 4.5);

        // Вызываем наш compareTo из Задания 4
        int result = s1.compareTo(s2);

        System.out.println("Сравниваем " + s1.name + " (ID " + s1.idNumber + ") и " + s2.name + " (ID " + s2.idNumber + ")");

        if (result > 0) {
            System.out.println("Результат: " + result + " (Вася больше Пети по ID)");
        } else if (result < 0) {
            System.out.println("Результат: " + result + " (Вася меньше Пети по ID)");
        } else {
            System.out.println("Результат: 0 (Они равны)");
        }
    }
}