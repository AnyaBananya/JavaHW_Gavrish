package homeWork3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
     * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Давай поиграем?\n" +
            "Я загадаю число от 0 до 9. У тебя будет 3 попытки это число отгадать. Начали!");

        boolean repeat = true;

        while (repeat) {
            System.out.println("Загадал...");

            boolean guessed = false;
            short generateNumber = (short) new Random().nextInt(10);
            short n = 3;
            //System.out.println(generateNumber);

            for (int i = 1; i <= n; i++) {
                short userNumber = sc.nextShort();

                if (userNumber < generateNumber) {
                    System.out.println("Больше!");
                } else if (userNumber > generateNumber) {
                    System.out.println("Меньше!");
                } else {
                    System.out.println("Умничка, отгадал!");
                    guessed = true;
                    break;
                }
                if (n - i != 0) {
                    System.out.printf("Осталось попыток - %d.\n", n - i);
                }
            }

            if (!guessed) {
                System.out.printf("Попытки закончились. Очень жаль, но ты не отгадал... Я загадал число %d\n", generateNumber);
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            repeat = sc.nextShort() == 1;
        }

        System.out.println("Игра окончена. Приходи еще!");
    }
}
