package level2.homeWork1;

public class Track implements Passable {
    private int lenght;

    public Track(int lenght) {
        this.lenght = lenght;
    }

    public void getInfo() {
        System.out.printf("===== This is a track [l = %d m] =====\n", lenght);
    }

    @Override
    public boolean pass(Runnable runner) {
        if (runner.canRun(lenght)) {
            runner.run(lenght);
            return true;
        } else {
            System.out.printf("%s cannot run!\n", runner.getName());
            return false;
        }
    }
}
