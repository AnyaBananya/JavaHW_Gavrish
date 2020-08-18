package level1.homeWork6.animals;

public class Animal {
    String name;
    String colour;
    int age;
    int swimOpportunity = 0;
    int runOpportunity = 0;
    static int count;

    public Animal(String name, String colour, int age) {
        this.name = name;
        this.colour = colour;
        this.age = age;
        count +=1;
    }

    public void swim(int distance) {
        if (distance <= swimOpportunity) {
            System.out.printf("%s swam %d kilometers\n", name, distance);
        } else {
            System.out.printf("%s can not swim %d kilometers. Its opportunity is %d kilometers \n", name, distance, swimOpportunity);
        }
    }

    public void run(int distance) {
        if (distance <= runOpportunity) {
            System.out.printf("%s run %d kilometers\n", name, distance);
        } else {
            System.out.printf("%s can not run %d kilometers. Its opportunity is %d kilometers \n", name, distance, runOpportunity);
        }
    }

    public static int getCount() {
        return count;
    }
}
