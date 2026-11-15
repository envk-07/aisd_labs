package pr10;

public class Task3 {

    Student[] merged;

    public Task3(Student[] a, Student[] b) {
        merged = new Student[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[a.length + i] = b[i];
        }
    }

    private int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    public void sort() {
        quickSort(merged, 0, merged.length - 1);
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


    public void outArray() {
        for (Student s : merged) {
            System.out.println(s);
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        Student[] arr1 = new Student[3];
        arr1[0] = new Student("Анна",  "Кузнецова", "ИТ", 1, "Б-101", 4.7);
        arr1[1] = new Student("Олег",  "Морозов",  "ИТ", 2, "А-201", 3.9);
        arr1[2] = new Student("Мария", "Волкова",  "ИТ", 3, "А-301", 4.4);

        Student[] arr2 = new Student[3];
        arr2[0] = new Student("Сергей", "Новиков",  "ИТ", 1, "Б-102", 4.1);
        arr2[1] = new Student("Лена",   "Соколова", "ИТ", 2, "А-202", 4.8);
        arr2[2] = new Student("Дима",   "Лебедев",  "ИТ", 3, "А-302", 3.6);

        Task3 t = new Task3(arr1, arr2);

        System.out.println("Объединённый массив:");
        t.outArray();

        t.sort();
        System.out.println("После сортировки (по GPA убыв.):");
        t.outArray();
    }
}