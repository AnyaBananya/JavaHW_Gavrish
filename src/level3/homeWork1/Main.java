package level3.homeWork1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /**
         * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
         */
        ArrayList<Integer> myArrList = new ArrayList<>();
        myArrList.add(1);
        myArrList.add(2);
        myArrList.add(3);
        myArrList.add(4);
        myArrList.add(5);

        System.out.println(changeArrElements(myArrList, 0, 4));

        /**
         * 2. Написать метод, который преобразует массив в ArrayList;
         */
        Integer[] myArr = {10, 11, 12, 13, 14};

        System.out.println(transformArrayToArrayList(myArr) instanceof ArrayList);

    }

    public static <T> ArrayList<T> changeArrElements(ArrayList<T> arr, int i, int j) {
        T c = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, c);
        return arr;
    }

    public static <T> ArrayList<T> transformArrayToArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }

        return arrayList;

        // Легкий способ
        // return Arrays.asList(arr);
    }
}
