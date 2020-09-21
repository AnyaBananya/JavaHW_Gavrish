package level3.homeWork1.fruits;

public class Main {
    public static void main(String[] args) {

        Box<Apple> boxWithApples = new Box();
        for (int i = 1; i <= 10; i++) {
            boxWithApples.addFruit(new Apple());
        }

        Box<Orange> boxWithOranges = new Box();
        for (int i = 1; i <= 10; i++) {
            boxWithOranges.addFruit(new Orange());
        }

        System.out.println("Размер коробки с яблоками: " + boxWithApples.getWeight());
        System.out.println("Размер коробки с апельсинами: " + boxWithOranges.getWeight());

        System.out.println(boxWithApples.compare(boxWithOranges) ? "Коробки равны по весу" : "Коробки не равны по весу");

        Box<Apple> newBoxWithApples = new Box();
        boxWithApples.pourOverTo(newBoxWithApples);

        for (int i = 1; i <= 5; i++) {
            newBoxWithApples.addFruit(new Apple());
        }

        System.out.println(newBoxWithApples.compare(boxWithOranges) ? "Коробки равны по весу" : "Коробки не равны по весу");

        System.out.println("Размер коробки с яблоками, из которой пересыпали яблоки: " + boxWithApples.getWeight());
        System.out.println("Размер коробки с яблоками, в которую пересупали яблоки: " + newBoxWithApples.getWeight());
    }
}
