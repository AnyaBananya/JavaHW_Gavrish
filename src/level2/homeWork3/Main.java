package level2.homeWork3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /**
         * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
         */

        String[] words = {"конь", "пальто", "муха", "цокотуха", "колобок", "лиса", "конь", "лиса",
            "волк", "медведь", "волк", "муха", "комар", "комар", "лиса", "конь", "яйцо", "город", "нос", "рот", "нос"};
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            Integer value = map.getOrDefault(word, 0);
            map.put(word, value + 1);
        }

        System.out.println("Уникальные слова:");
        map.forEach((k, v) -> System.out.println(k));

        System.out.println();
        System.out.println("Сколько раз встречается каждое слово:");
        System.out.println(map);
    }
}
