package level2.homeWork2;

public class Main {
    public static final int ARR_LENGTH = 4;

    public static void main(String[] args) {
        String[][] arr1 = {
            {"1", "2", "3", "4"},
            {"5", "6ff", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        try {
            System.out.printf("Сумма элементов массива = %d\n", arraySum(arr1));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != ARR_LENGTH) {
            throw new MyArraySizeException("Неверный размер массива!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != ARR_LENGTH) {
                throw new MyArraySizeException("Неверный размер массива!");
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невозможно преобразовать элемент [" + i + "][" + j + "]", i, j);
                }
            }
        }
        return sum;
    }
}
