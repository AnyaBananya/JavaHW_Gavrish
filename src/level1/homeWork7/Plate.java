package level1.homeWork7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        food -= amount;
    }

    public boolean isFoodEnough(int amount) {
        return food - amount >= 0;
    }

    public void increaseFood(int newFood) {
        food += newFood;
    }

    @Override
    public String toString() {
        return "Plate{" +
            "food=" + food +
            '}';
    }
}
