package level1.homeWork6;

import level1.homeWork6.animals.*;

public class Main {
    public static void main(String[] args) {
//        Dog dog = new Dog("Пряня", "White-red", 3);
//        Cat cat = new Cat("Кокося", "Black", 7);

        //        dog.run(10);
        //        dog.run(3000);
        //        dog.swim(5);
        //        dog.swim(2000);
        //
        //        cat.run(10);
        //        cat.run(3000);
        //        cat.swim(50);

        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Бобик", "White", 10);
        animals[1] = new Dog("Тузик", "Black", 5);
        animals[2] = new Cat("Кокося", "Black", 7);
        animals[3] = new Animal("Ктулху", "Undefined", 20);

        // 4.* Добавить подсчет созданных котов, собак и животных.
        // Вариант 1

        int dogCount = 0;
        int catCount = 0;
        int animalCount = 0;

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                dogCount += 1;
            } else if (animal instanceof Cat) {
                catCount += 1;
            }
            animalCount += 1;
        }
//        System.out.printf("Dog count is %d\n", dogCount);
//        System.out.printf("Cat count is %d\n", catCount);
//        System.out.printf("Animals count is %d\n", animalCount);

        // Вариант 2
        System.out.printf("Dog count is %d\n", Dog.getCount());
        System.out.printf("Cat count is %d\n", Cat.getCount());
        System.out.printf("Animals count is %d\n", Animal.getCount());
    }
}
