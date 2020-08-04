package homeWork6.animals;

public class Dog extends Animal {
    static int dogCount;

    public Dog(String name, String colour, int age) {
        super(name, colour, age);
        super.runOpportunity = 500;
        super.swimOpportunity = 10;
        dogCount += 1;
    }

    public static int getCount() {
        return dogCount;
    }
}
