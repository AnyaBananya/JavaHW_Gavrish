package level1;

public class Main {
    public static void main(String[] args) {
        byte b = 122;
        int i = 10;
        short s = 1;
        long l = 12555555345L;
        float f = 123.4f;
        double d = 1133.22;
        char c = 'h';
        boolean bo = true;
        String str = "Строка";
    }

    public static float calculate(float a, float b, float c, float d) {
        return a * (b + c / d);
    }

    public static boolean isSumInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void writeNumberIsPositive(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void greeting(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    public static void isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.printf("Год %s является високосным\n", year);
        } else {
            System.out.printf("Год %s не является високосным\n", year);
        }
    }
}
