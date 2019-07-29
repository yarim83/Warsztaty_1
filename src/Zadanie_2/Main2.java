package Zadanie_2;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*

Symulator LOTTO
Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu od 1 do 49.
Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest tra enie 3, 4, 5 lub 6
poprawnych liczb.
Napisz program, który:
zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
- czy wprowadzony ciąg znaków jest poprawną liczbą,
- czy użytkownik nie wpisał tej liczby już poprzednio,
- czy liczba należy do zakresu 1-49,
po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
poinformuje gracza, czy tra ł przynajmniej "trójkę".
7

Aby wylosować 6 liczb z zakresu 1-49 bez powtórzeń możemy utworzyć tablicę z wartościami z tego
zakresu, wymieszać jej zawartość i pobrać pierwsze 6 elementów.
Poniższy kod powinien Ci pomóc:
Integer[] arr = new Integer[49];
for (int i = 0; i < arr.length; i++) {
arr[i] = i + 1;
}
System.out.println(Arrays.toString(arr));
Collections.shuffle(Arrays.asList(arr));
System.out.println(Arrays.toString(arr));
Możesz również losować liczby z określonego zakresu przy użyciu klasy Random (sprawdź w
snippetach jak to wykonać) – jeżeli wybierzesz takie rozwiązanie, pamiętaj o sprawdzaniu czy dana
wartość nie została wcześniej wylosowana.





 */
public class Main2 {

    public static void main(String[] args) {

            int[] readedNumbers = new int[6];
            System.out.println(" " + Arrays.toString(readedNumbers));
            boolean checkNumber = true;
            int readedNumber;

            for (int i = 0; i < readedNumbers.length; i++) {
                System.out.printf("Podaj liczbę: ");
                readedNumber = readNumber();
                while (check(readedNumber, readedNumbers) != true) {
                    System.out.printf("Podaj nową liczbę: ");
                    readedNumber = readNumber();
                }
                readedNumbers[i] = readedNumber;
            }
            Arrays.sort(readedNumbers);
            System.out.println("Twoje wybrane liczby to: \n" + Arrays.toString(readedNumbers));
            System.out.println("Wygenerowano następujace liczby:");
            Integer[] generatedLottoNumber = generateLottoNumber();
            System.out.println(" " + Arrays.toString(generatedLottoNumber));
            System.out.println(chechHit(readedNumbers, generatedLottoNumber));

        System.out.println("\n" +
                "\n" +
                "Dziękuję za wspólną grę");
    }

    // SEKCJA METOD

    static int readNumber() {
        Scanner readNumbers = new Scanner(System.in);
        while (!readNumbers.hasNextInt()) {
            readNumbers.next();
            System.out.printf("Nie podałeś poprawnej liczby");
        }
        int number = readNumbers.nextInt();
        return number;
    }

    static boolean check(int readedNumber, int[] readedNumbers) {
        boolean checkedNumber = true;
        for (int i = 0; i < readedNumbers.length; i++) {
            if (readedNumber > 0 && readedNumber < 50) {
                if (readedNumber != readedNumbers[i]) {
                    checkedNumber = true;
                } else {
                    checkedNumber = false;
                    break;
                }
            } else {
                checkedNumber = false;
                break;
            }
        }
        return checkedNumber;
    }

    static String chechHit(int[] readedNumbers, Integer[] generetedNumbers) {
        int resultCounter = 0;
        String result = null;
        for (int i = 0; i < generetedNumbers.length; i++) {
            for (int j = 0; j < readedNumbers.length; j++) {
                if (generetedNumbers[i] == readedNumbers[j]) {
                    resultCounter++;
                }
            }
        }

        switch (resultCounter) {
            case 1:
                result = "Nic nie wygrałeś. Miałeś jedno trafienie";
                break;
            case 2:
                result = "Nic nie wygrałeś. Trafiłeś dwóję";
                break;
            case 3:
                result = "Trafiłeś trójkę";
                break;
            case 4:
                result = "Trafiłeś czwórkę";
                break;
            case 5:
                result = "Trafiłeś piątkę";
                break;
            case 6:
                result = "!!!! Trafiłeś szóstkę !!!!";
                break;
            default:
                result = "Nic nie trafiłeś";
                break;
        }

        return result;
    }

    static Integer[] generateLottoNumber() {

        Integer[] arr = new Integer[49];
        Integer[] generetedNumbers = new Integer[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        generetedNumbers = Arrays.copyOf(arr, 6);
        return generetedNumbers;
    }

}


