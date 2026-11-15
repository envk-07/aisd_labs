package pr13;

public class Person {
    String surname;
    String name;
    String patronymic;

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getShortName() {
        // StringBuilder быстрее, чем склеивать через +
        StringBuilder sb = new StringBuilder();
        sb.append(surname);

        if (name != null && name.length() > 0) {
            sb.append(" ").append(name.charAt(0)).append(".");
        }
        if (patronymic != null && patronymic.length() > 0) {
            sb.append(patronymic.charAt(0)).append(".");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Person p1 = new Person("Иванов", "Иван", "Иванович");
        Person p2 = new Person("Петров", "Петр", "");
        Person p3 = new Person("Сидоров", null, null);

        System.out.println(p1.getShortName()); // Иванов И.И.
        System.out.println(p2.getShortName()); // Петров П.
        System.out.println(p3.getShortName()); // Сидоров
    }
}