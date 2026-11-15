package pr9;

import java.util.Comparator;

public class Task3 {
    public static void main(String[] args) {
        // Допустим, у нас уже есть два отсортированных по GPA списка
        Student[] list1 = {
                new Student("Оля", 105, 4.9),
                new Student("Вася", 103, 4.5)
        };

        Student[] list2 = {
                new Student("Петя", 101, 3.8),
                new Student("Даша", 102, 3.2)
        };

        SortingStudentsByGPA comp = new SortingStudentsByGPA();

        // Сливаем их
        Student[] mergedList = merge(list1, list2, comp);

        System.out.println("После слияния двух списков:");
        for (Student s : mergedList) System.out.println(s);
    }

    // Метод слияния
    public static Student[] merge(Student[] list1, Student[] list2, Comparator<Student> comp) {
        // Создаем новый массив, куда всё сольем
        Student[] result = new Student[list1.length + list2.length];

        int i = 0; // указатель для первого списка
        int j = 0; // указатель для второго
        int k = 0; // указатель для итогового

        // Бежим по обоим спискам, пока они не кончатся
        while (i < list1.length && j < list2.length) {
            // Сравниваем, чей элемент "больше" (по убыванию)
            if (comp.compare(list1[i], list2[j]) >= 0) {
                result[k] = list1[i];
                i++;
            } else {
                result[k] = list2[j];
                j++;
            }
            k++;
        }

        // Если в первом списке что-то осталось, докидываем в конец
        while (i < list1.length) {
            result[k] = list1[i];
            i++;
            k++;
        }

        // Если во втором осталось, докидываем его
        while (j < list2.length) {
            result[k] = list2[j];
            j++;
            k++;
        }

        return result;
    }
}