package pr11;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task5 {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            a1.add(i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList  добавление в конец: " + (end - start) / 1000000.0 + " мс");

        LinkedList<Integer> l1 = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            l1.add(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList добавление в конец: " + (end - start) / 1000000.0 + " мс");

        ArrayList<Integer> a2 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) a2.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            a2.add(0, -i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList  вставка в начало:  " + (end - start) / 1000000.0 + " мс");

        LinkedList<Integer> l2 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) l2.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            l2.add(0, -i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList вставка в начало:  " + (end - start) / 1000000.0 + " мс");
        ArrayList<Integer> a3 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) a3.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            a3.get(50000);
        }
        end = System.nanoTime();
        System.out.println("ArrayList  поиск по индексу:  " + (end - start) / 1000000.0 + " мс");

        LinkedList<Integer> l3 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) l3.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            l3.get(50000);
        }
        end = System.nanoTime();
        System.out.println("LinkedList поиск по индексу:  " + (end - start) / 1000000.0 + " мс");


        // 4. ПОИСК ПО ЗНАЧЕНИЮ (indexOf) — "поиск по образцу"
        ArrayList<Integer> a4 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) a4.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            a4.indexOf(50000);
        }
        end = System.nanoTime();
        System.out.println("ArrayList  поиск по значению: " + (end - start) / 1000000.0 + " мс");

        LinkedList<Integer> l4 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) l4.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            l4.indexOf(50000);
        }
        end = System.nanoTime();
        System.out.println("LinkedList поиск по значению: " + (end - start) / 1000000.0 + " мс");


        ArrayList<Integer> a5 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) a5.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            a5.remove(0);
        }
        end = System.nanoTime();
        System.out.println("ArrayList  удаление из начала: " + (end - start) / 1000000.0 + " мс");

        LinkedList<Integer> l5 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) l5.add(i);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            l5.remove(0);
        }
        end = System.nanoTime();
        System.out.println("LinkedList удаление из начала: " + (end - start) / 1000000.0 + " мс");
    }
}