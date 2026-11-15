package pr9;

public class Student implements Comparable<Student> {
    String name;
    int idNumber;
    double gpa; // итоговые баллы

    public Student(String name, int idNumber, double gpa) {
        this.name = name;
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    // Геттер для баллов, нужен для 2 задания
    public double getGpa() {
        return gpa;
    }

    // Задание 4: Своя реализация Comparable.
    // Сравниваем по idNumber.
    public int compareTo(Student other) {
        return Integer.compare(this.idNumber, other.idNumber);
    }

    // Чтобы в консоли нормально выводилось
    public String toString() {
        return "Студент " + name + " | ID: " + idNumber + " | GPA: " + gpa;
    }
}