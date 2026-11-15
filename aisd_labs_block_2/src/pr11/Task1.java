package pr11;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
        String surname = "Евсеенко";

        Date received = new Date();

        long oneHour = 60L * 60L * 1000L;
        Date submitted = new Date(received.getTime() + oneHour);

        System.out.println("Фамилия разработчика: " + surname);
        System.out.println("Получено: " + received);
        System.out.println("Сдано:    " + submitted);
    }
}