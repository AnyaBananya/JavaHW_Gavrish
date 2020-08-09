package homeWork6.animals;

public class Cat extends Animal {
    static int catCount;

    public Cat(String name, String colour, int age) {
        super(name, colour, age);
        super.runOpportunity = 200;
        catCount += 1;
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Cats can not swim! %s is a cat\n", name);
    }

    public static int getCount() {
        return catCount;
    }
}
