package pr13;

import java.util.StringTokenizer;

public class Address     {
    String country;
    String region;
    String city;
    String street;
    String house;
    String building;
    String apartment;

    // Вариант А: только запятая
    public void parseWithSplit(String input) {
        String[] parts = input.split(",");
        if (parts.length >= 7) {
            country = parts[0].trim();
            region = parts[1].trim();
            city = parts[2].trim();
            street = parts[3].trim();
            house = parts[4].trim();
            building = parts[5].trim();
            apartment = parts[6].trim();
        }
    }

    // Вариант Б: любой из разделителей , . ;
    public void parseWithTokenizer(String input) {
        StringTokenizer st = new StringTokenizer(input, ",.;");
        if (st.hasMoreTokens()) country = st.nextToken().trim();
        if (st.hasMoreTokens()) region = st.nextToken().trim();
        if (st.hasMoreTokens()) city = st.nextToken().trim();
        if (st.hasMoreTokens()) street = st.nextToken().trim();
        if (st.hasMoreTokens()) house = st.nextToken().trim();
        if (st.hasMoreTokens()) building = st.nextToken().trim();
        if (st.hasMoreTokens()) apartment = st.nextToken().trim();
    }

    public String toString() {
        return country + ", " + region + ", " + city + ", " +
                street + ", д." + house + ", к." + building + ", кв." + apartment;
    }

    public static void main(String[] args) {
        String[] tests = {
                "Россия, Москва, Москва, Тверская, 1, 2, 10",
                "США; Нью-Йорк; Нью-Йорк; Бродвей; 100; ; 5",
                "Германия. Бавария. Мюнхен. Мариенплац. 1. А. 10",
                "Россия, Санкт-Петербург, Санкт-Петербург, Невский, 100, , 1"
        };

        for (String s : tests) {
            Address a = new Address();
            if (s.contains(",")) {
                a.parseWithSplit(s);
            } else {
                a.parseWithTokenizer(s);
            }
            System.out.println(a);
        }
    }
}