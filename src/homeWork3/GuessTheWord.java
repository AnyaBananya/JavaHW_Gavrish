package homeWork3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    /**
     * Создать массив из слов
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
     * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
     * "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
     * <p>
     * Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно можно пользоваться:
     * String str = "apple";
     * char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово.
     * Используем только маленькие буквы.
     */

    public static Scanner sc = new Scanner(System.in);

    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
        "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
        "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        System.out.println("Давай поиграем?\nЯ загадал одно из следующих слов:");
        System.out.println(Arrays.toString(words));

        String randomWord = getRandomWord(words);
        //System.out.println(randomWord);

        boolean guessed = false;

        while (!guessed) {
            String userWord = sc.next();
            StringBuilder tempWord = new StringBuilder("###############");

            if (userWord.equals(randomWord)) {
                System.out.println("У тебя явно есть экстраординарные способности! Браво! Ты угадал слово!");
                guessed = true;
            } else {
                int length = randomWord.length() > userWord.length() ? userWord.length() : randomWord.length();
                boolean luckyGuy = false;

                for (int i = 0; i < length; i++) {
                    char a = randomWord.charAt(i);
                    if (a == userWord.charAt(i)) {
                        tempWord.setCharAt(i, a);
                        luckyGuy = true;
                    }
                }

                if (!luckyGuy) {
                    System.out.println("Эх, в Битве Экстрасенсов ты явно проиграешь. Нет ни одной правильной буквы...");
                } else {
                    System.out.println("Ты угадал несколько букв");
                }

                System.out.println(tempWord.toString());
            }
        }
    }

    /**
     * Получение рандомного слова из заданного массива слов
     *
     * @param words массив слов
     * @return рандомное слово
     */
    public static String getRandomWord(String[] words) {
        int randomIndex = new Random().nextInt(words.length);
        return words[randomIndex];
    }
}
