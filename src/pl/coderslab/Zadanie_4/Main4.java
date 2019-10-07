package pl.coderslab.Zadanie_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        int[] result;
        int count = 1;
        Random random = new Random();
        System.out.println("Czas pograć");
        System.out.println("Podaj skrócony zapis rzutu kostką");
        System.out.println("Wzór to xDy+z");
        System.out.println("Rzut : " + count + " - Wprowadź zapis: ");
        do {
            int throwResult = 0;
            count++;
            result = readDice().clone();
            System.out.println(Arrays.toString(result));
            if (result[2] == 0) {
                throwResult = generateRandomDice(1, Array.getInt(result, 1), Array.getInt(result, 0));
            } else if (result[2] == 1) {
                throwResult = generateRandomDice(1, Array.getInt(result, 1), Array.getInt(result, 0));
                throwResult = throwResult + result[3];
            } else if (result[2] == -1) {
                throwResult = generateRandomDice(1, Array.getInt(result, 1), Array.getInt(result, 0));
                throwResult = throwResult - result[3];
            } else {
                System.out.println("Coś poszło nie tak");
            }
            System.out.println("Wynik rzutu kostką: " + throwResult);
            System.out.print("Rzut: " + count + " - Rzuć ponownie: ");
        } while (result[4] != 1);


    }

    public static int[] readDice() {
        String readedDice = null;
        int x = 0, y = 0, z = 0;
        //Dice schema xDy+z
        //Opis result | result[0] - ilość rzutów, [1] - kostka, [2] - znak, [3] - liczba ktora należy dodać/odjąć,
        // [4] - exit
        int[] result = new int[5];

        Scanner scanner = new Scanner(System.in);
        readedDice = scanner.nextLine();
        String exitWord = readedDice;

        if (exitWord.equalsIgnoreCase("exit")) {
            result[4] = 1;
        }

        if (readedDice.contains("d") || readedDice.contains("D")) {
            readedDice = readedDice.toLowerCase();
            String[] partsDice = readedDice.split("d", 2);
            //System.out.println(Arrays.toString(partsDice));
            try {
                //result[0] = Integer.parseInt(partsDice[0]);
                if (readedDice.contains("+")) {
                    String[] partsRight = partsDice[1].split("\\+", 2);
                    if (!partsDice[0].isEmpty()) {
                        result[0] = Integer.parseInt(partsDice[0]);
                    } else {
                        result[0] = 1;
                    }
                    result[1] = Integer.parseInt(partsRight[0]);
                    result[2] = 1;
                    result[3] = Integer.parseInt(partsRight[1]);
                } else if (readedDice.contains("-")) {
                    String[] partsRight = partsDice[1].split("-", 2);
                    if (!partsDice[0].isEmpty()) {
                        result[0] = Integer.parseInt(partsDice[0]);
                    } else {
                        result[0] = 1;
                    }
                    result[1] = Integer.parseInt(partsRight[0]);
                    result[2] = -1;
                    result[3] = Integer.parseInt(partsRight[1]);
                } else {
                    result[0] = 1;
                    result[1] = Integer.parseInt(partsDice[1]);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Wprowadziłeś błędne wyrażenie logiczne" + nfe.getMessage());
            }

        } else {
            System.out.println("Wprowadziłeś błędną kontrukcję wyrażenia");
            System.out.println(readedDice);
            result[4] = 0;
        }

        return result;

    }

    public static int generateRandomDice(int min, int max, int diceThrows) {
        Random random = new Random();
        int throwResult = 0;
        for (int i = 0; i < diceThrows; i++) {
            int rnd = 0;
            rnd = random.nextInt((max - min) + 1) + min;
            System.out.println("Rzuciłeś " + (i + 1) + " raz, wynik to: " + rnd);
            throwResult += rnd;
        }

        return throwResult;
    }


}
