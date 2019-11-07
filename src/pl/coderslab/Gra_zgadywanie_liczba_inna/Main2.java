package pl.coderslab.Gra_zgadywanie_liczba_inna;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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


