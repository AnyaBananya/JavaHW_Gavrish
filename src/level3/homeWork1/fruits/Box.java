package level3.homeWork1.fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<? extends Fruit> anotherBox){
        return Math.abs(getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void pourOverTo(Box<T> anotherBox){
        for (T fruit: fruits) {
            anotherBox.addFruit(fruit);
        }
        fruits.clear();
    }
}
