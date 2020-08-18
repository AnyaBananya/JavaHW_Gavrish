package level1.homeWork2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        */
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] == 0 ? 1 : 0;
        }
        //System.out.println(Arrays.toString(arr1));

        /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        int[] arr2 = new int[8];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 3 * i;
        }
        //System.out.println(Arrays.toString(arr2));

        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        //System.out.println(Arrays.toString(arr3));

        /*
        4. Создать квадратный двумерный целочисленный массив
        (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        заполнить его диагональные элементы единицами;
        */
        int[][] arr4 = {
            {1, 2, 3, 10},
            {4, 5, 6, 20},
            {7, 8, 9, 30},
            {40, 50, 60, 70},
        };

        // Вариант решения с вложенным циклом
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j || i + j == arr4.length - 1) {
                    arr4[i][j] = 1;
                }
            }
        }
        // printArray(arr4);

        // Вариант решения без вложенного цикла
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4.length - 1 - i] = 1;
        }
        // printArray(arr4);

       /*
       5. ** Задать одномерный массив и найти в нем минимальный
       и максимальный элементы (без помощи интернета);
        */
        int[] arr5 = {3, 6, 4, 1, 7, 9};
        int min = arr5[0];
        int max = arr5[0];

        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] < min) {
                min = arr5[i];
            }
            if (arr5[i] > max) {
                max = arr5[i];
            }
        }
        //System.out.printf("Max = %d, min = %d\n", max, min);

        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
         */
        int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println(checkBalance2(arr6));

        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
         */
        int[] arr7 = {0, 1, 2, 3, 4, 5};
        moveArray(-7, arr7);
        System.out.println(Arrays.toString(arr7));
    }

    // Первый вариант решения
    public static boolean checkBalance(int[] a) {
        if (a.length < 2) {
            return false;
        }

        int l = 0;
        int r = a.length - 1;
        int rightSum = a[r];
        int leftSum = a[l];

        while (r - l > 1) {
            if (leftSum <= rightSum) {
                l++;
                leftSum += a[l];
            } else {
                r--;
                rightSum += a[r];
            }
        }
        return leftSum == rightSum;
    }

    // Второй вариант решения
    public static boolean checkBalance2(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int leftSum = 0;

        for (int i = 0; i < a.length; i++) {
            leftSum += a[i];

            if (leftSum == sum / 2) {
                return true;
            }
        }
        return false;
    }

    public static int[] moveArray(int n, int[] arr) {
        n %= arr.length;

        if (n < 0) {
            n = arr.length + n;
        }

        for (int i = 0; i < n; i++) {
            moveArray(arr);
        }
        return arr;
    }

    public static int[] moveArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int a = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = a;
        }
        return arr;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
