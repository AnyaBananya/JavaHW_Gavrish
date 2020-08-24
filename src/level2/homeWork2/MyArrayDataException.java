package level2.homeWork2;

public class MyArrayDataException extends NumberFormatException {
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public MyArrayDataException(String s, int i, int j) {
        super(s);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
