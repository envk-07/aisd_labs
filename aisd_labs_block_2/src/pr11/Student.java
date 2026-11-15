package pr11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String name;
    private String surname;
    private String specialty;
    private int course;
    private String group;
    private Date birthDate;

    public Student(String name, String surname, String specialty,
                   int course, String group, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getName()      { return name; }
    public String getSurname()   { return surname; }
    public String getSpecialty() { return specialty; }
    public int getCourse()       { return course; }
    public String getGroup()     { return group; }
    public Date getBirthDate()   { return birthDate; }

    public void setName(String name)           { this.name = name; }
    public void setSurname(String surname)     { this.surname = surname; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setCourse(int course)          { this.course = course; }
    public void setGroup(String group)         { this.group = group; }
    public void setBirthDate(Date birthDate)   { this.birthDate = birthDate; }

    // Возвращает дату рождения в нужном формате.
    // "short"  -> 15.05.05
    // "medium" -> 15 мая 2005
    // "full"   -> воскресенье, 15 мая 2005
    // любое другое -> "неизвестный формат"
    public String getBirthDateFormatted(String format) {
        SimpleDateFormat sdf;

        if (format.equals("short")) {
            sdf = new SimpleDateFormat("dd.MM.yy");
        } else if (format.equals("medium")) {
            sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("ru"));
        } else if (format.equals("full")) {
            sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("ru"));
        } else {
            return "неизвестный формат";
        }

        return sdf.format(birthDate);
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialty='" + specialty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                ", birthDate=" + getBirthDateFormatted("medium") +
                '}';
    }
}