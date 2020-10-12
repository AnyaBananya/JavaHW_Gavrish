import java.util.Arrays;

public class MainApp {
    public static final String ERROR_MES = "В массиве нет 4";

     public static int[] getNumbersAfterLast4(int[] arr) {
        int k = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                k = i;
            }
        }

        if (k == -1) {
            throw new RuntimeException(ERROR_MES);
        }

        int[] newArr = new int[arr.length - k - 1];
        System.arraycopy(arr, k + 1, newArr, 0, arr.length - k - 1);
        return newArr;
    }

    public static boolean has1and4(int[] arr) {
        int count1 = 0;
        int count4 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count1 += 1;
            }
            if (arr[i] == 4) {
                count4 += 1;
            }
        }

        return count1 > 0 && count4 > 0 && count1 + count4 == arr.length;
    }
}
