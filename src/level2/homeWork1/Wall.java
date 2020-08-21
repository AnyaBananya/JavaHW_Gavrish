package level2.homeWork1;

public class Wall implements Passable {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void getInfo() {
        System.out.printf("##### This is a wall [h = %d sm] #####\n", height);
    }

    @Override
    public boolean pass(Runnable runner) {
        if (runner.canJump(height)) {
            runner.jump(height);
            return true;
        } else {
            System.out.printf("%s cannot jump!\n", runner.getName());
            return false;
        }
    }
}
