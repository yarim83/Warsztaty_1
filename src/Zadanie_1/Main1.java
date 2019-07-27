package Zadanie_1;

import java.util.Random;
import java.util.Scanner;

/*
Gra w zgadywanie liczb Napisz prostą grę w zgadywanie liczb. Komputer ma wylosować liczbę w zakresie od 1 do 100.
Następnie:

wypisać: "Zgadnij liczbę" i pobrać liczbę z klawiatury;
sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat: "To nie jest liczba",
po czym wrócić do pkt. 1;
jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat: "Za mało!",
po czym wrócić do pkt. 1;
jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat: "Za dużo!",
 po czym wrócić do pkt. 1;
jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat: "Zgadłeś!",
po czym zakończyć działanie programu.
 */
public class Main1 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean result = false;
        int rnd = random.nextInt(101);

        do {
            System.out.print("Zgadnij liczbę: ");
            int keyReaded = readKey();
            if (keyReaded < rnd) {
                System.out.printf("Za mało\n");
                result = false;
            } else if (keyReaded > rnd) {
                System.out.printf("Za dużo\n");
                result = false;
            } else if (keyReaded == rnd) {
                result = true;
            }
        } while (!result);
        System.out.printf("Zgadłeś");
    }


    static int readKey() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("To nie jest liczba.");
            System.out.printf("Zgadnij liczbę: ");
        }
        int number = scanner.nextInt();

        return number;
    }

}
