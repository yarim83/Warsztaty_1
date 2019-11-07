package pl.coderslab.Gra_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

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
        scanner.close();
        return number;
    }

}
