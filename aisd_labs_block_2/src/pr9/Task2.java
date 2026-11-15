package pr9;

import java.util.Comparator;

// Задание 2: Класс-компаратор для сортировки по GPA (убывание)
class SortingStudentsByGPA implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }
}

public class Task2 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Вася", 103, 4.5),
                new Student("Петя", 101, 3.8),
                new Student("Оля", 105, 4.9),
                new Student("Даша", 102, 3.2)
        };

        SortingStudentsByGPA comparator = new SortingStudentsByGPA();

        System.out.println("До быстрой сортировки:");
        for (Student s : students) System.out.println(s);

        quickSort(students, 0, students.length - 1, comparator);

        System.out.println("\nПосле быстрой сортировки (по GPA убыв.):");
        for (Student s : students) System.out.println(s);
    }

    // Рекурсивная быстрая сортировка
    public static void quickSort(Student[] arr, int low, int high, Comparator<Student> comp) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, comp);
            quickSort(arr, low, pivotIndex - 1, comp);
            quickSort(arr, pivotIndex + 1, high, comp);
        }
    }

    // Разделение массива (выбор опорного элемента)
    private static int partition(Student[] arr, int low, int high, Comparator<Student> comp) {
        Student pivot = arr[high]; // Опорный - последний
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Если текущий элемент "больше" опорного (по нашему компаратору)
            if (comp.compare(arr[j], pivot) >= 0) {
                i++;
                // Меняем местами
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Ставим опорный на место
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}