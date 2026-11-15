package pr9;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        // Создаем массив студентов (они не отсортированы)
        Student[] students = {
                new Student("Вася", 103, 4.5),
                new Student("Петя", 101, 3.8),
                new Student("Оля", 105, 4.9),
                new Student("Даша", 102, 3.2)
        };

        System.out.println("До сортировки вставками:");
        for (Student s : students) System.out.println(s);

        // Вызываем сортировку. Передаем как Comparable[], чтобы показать полиморфизм
        insertionSort(students);

        System.out.println("\nПосле сортировки вставками (по ID):");
        for (Student s : students) System.out.println(s);
    }

    // Сама сортировка вставками
    public static void insertionSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            Comparable current = list[i];
            int j = i;

            // Пока элемент слева больше текущего, сдвигаем его вправо
            while (j > 0 && list[j - 1].compareTo(current) > 0) {
                list[j] = list[j - 1];
                j--;
            }
            // Вставляем текущий элемент на освободившееся место
            list[j] = current;
        }
    }
}