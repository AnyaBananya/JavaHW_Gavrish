package level1.homeWork7;

public class Cat {
    private String name;
    private int foodAbility;
    private boolean satiety;

    public Cat(String name, int foodAbility) {
        this.name = name;
        this.foodAbility = foodAbility;
        satiety = false;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (plate.isFoodEnough(foodAbility)) {
            plate.decreaseFood(foodAbility);
            satiety = true;
            System.out.printf("Cat %s is eating\n", name);
        } else {
            System.out.printf("Cat %s is not eating, because he wants %d units of food " +
                "and plate has only %d units.\n", name, foodAbility, plate.getFood());
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    @Override
    public String toString() {
        return "Cat " + name + " is" + (satiety ? "" : " not") + " full";
    }
}
