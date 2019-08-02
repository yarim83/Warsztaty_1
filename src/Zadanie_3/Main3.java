package Zadanie_3;

import javax.security.auth.login.AccountLockedException;
import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {

        int min = 0;
        int max = 1000;
        int wynik = 0, count = 0;
        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach.");
        int guess = (max - min) / 2 + min;

        for (int i = 0; i < 11; i++) {
            System.out.println("Zgaduję:" + guess);
            wynik = readAnwser();
            switch (wynik) {
                case 1:
                    max = guess;
                    guess = (max - min) / 2 + min;
                    break;
                case 2:
                    min = guess;
                    guess = (max - min) / 2 + min;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Nie oszukuj");
                    break;
            }

            if (wynik == 3) {
                break;
            }

        }
        if (wynik == 3) {
            System.out.println("Wygrałeś");
        } else {
            System.out.println("Przegrałeś!." +
                    "\n Przekroczyłeś licznyk");
        }

    }
    //Sekcja na klasy

    public static int readAnwser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dobrze trafiłem ? ");
        System.out.println("1. za dużo[1]");
        System.out.println("2. za mało[2]");
        System.out.println("3. zgadleś[3]");

        System.out.print("Podaj odpowiedź:");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Wprowadziłeś niepoprawny znak. Wprowadź liczbę 1, 2 lub 3");
            System.out.print("Wprowadź liczbę ponownie");
        }

        int result = scanner.nextInt();

        return result;
    }
}
