package level2.homeWork1;

public interface Runnable {
    void run(int length);

    void jump(int height);

    boolean canRun(int length);

    boolean canJump(int height);

    String getName();
}
