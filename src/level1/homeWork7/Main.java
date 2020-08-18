package level1.homeWork7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
            new Cat("Barsik", 10),
            new Cat("Murka", 20),
            new Cat("Rizhik", 40),
            new Cat("Kokosya", 50),
        };

        Plate plate = new Plate(100);

        for (Cat cat : cats) {
            cat.eat(plate);
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }

        System.out.println(plate);
        plate.increaseFood(20);
        System.out.println(plate);
        cats[3].eat(plate);
        System.out.println(plate);
        System.out.println(cats[3]);
    }
}
