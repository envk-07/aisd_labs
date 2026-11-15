package pr10;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    Student[] iDNumber;

    public SortingStudentsByGPA(int size) {
        iDNumber = new Student[size];
    }

    // п.1 — заполнение массива
    public void setArray() {
        iDNumber[0] = new Student("Иван",  "Иванов",   "ИТ", 2, "А-201", 4.5);
        iDNumber[1] = new Student("Петр",  "Петров",   "ИТ", 1, "Б-102", 3.8);
        iDNumber[2] = new Student("Оля",   "Сидорова", "ИТ", 3, "А-301", 4.9);
        iDNumber[3] = new Student("Даша",  "Смирнова", "ИТ", 1, "Б-103", 4.1);
    }

    // п.3 — вывод массива
    public void outArray() {
        for (Student s : iDNumber) {
            System.out.println(s);
        }
        System.out.println("-------------------");
    }

    // компаратор по GPA (по убыванию)
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    // п.2 — быстрая сортировка
    public void quicksort() {
        quickSort(iDNumber, 0, iDNumber.length - 1);
    }

    private void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(Student[] arr, int low, int high) {
        Student pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) <= 0) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // второй алгоритм — сортировка слиянием
    public void mergesort() {
        iDNumber = mergeSort(iDNumber);
    }

    private Student[] mergeSort(Student[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;

        Student[] left  = new Student[mid];
        Student[] right = new Student[arr.length - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];
        for (int i = mid; i < arr.length; i++) right[i - mid] = arr[i];

        left  = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private Student[] merge(Student[] left, Student[] right) {
        Student[] result = new Student[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (compare(left[i], right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length)  result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    // п.4 — сортировка по другому полю (курс)
    public void sortByCourse() {
        for (int i = 0; i < iDNumber.length - 1; i++) {
            for (int j = 0; j < iDNumber.length - 1 - i; j++) {
                if (iDNumber[j].getCourse() > iDNumber[j + 1].getCourse()) {
                    Student temp = iDNumber[j];
                    iDNumber[j] = iDNumber[j + 1];
                    iDNumber[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortingStudentsByGPA tester = new SortingStudentsByGPA(4);
        tester.setArray();

        System.out.println("Исходный массив:");
        tester.outArray();

        tester.quicksort();
        System.out.println("После быстрой сортировки (по GPA убыв.):");
        tester.outArray();

        tester.setArray();
        tester.mergesort();
        System.out.println("После сортировки слиянием (по GPA убыв.):");
        tester.outArray();

        tester.setArray();
        tester.sortByCourse();
        System.out.println("После сортировки по курсу (возр.):");
        tester.outArray();
    }
}