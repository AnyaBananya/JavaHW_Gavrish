package level2.homeWork1;

public class Cat implements Runnable {
    private String name;
    private int runAbility;
    private int jumpAbility;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int runAbility, int jumpAbility) {
        this.name = name;
        this.runAbility = runAbility;
        this.jumpAbility = jumpAbility;
    }

    @Override
    public void run(int l) {
        System.out.printf("Cat %s is running %d m\n", this.getName(), l);
    }

    @Override
    public void jump(int h) {
        System.out.printf("Cat %s is jumping on %d sm\n", this.getName(), h);
    }

    @Override
    public boolean canJump(int h) {
        return jumpAbility >= h;
    }

    @Override
    public boolean canRun(int l) {
        return runAbility >= l;
    }

    @Override
    public String getName() {
        return name + " [l = " + runAbility + " m]" + " [h = " + jumpAbility + " sm]";
    }
}
