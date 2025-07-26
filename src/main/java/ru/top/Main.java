package ru.top;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        1) Есть 2 массива в отсортированном виде
//        { -10,-5,0,1,1,2,2,3,3,6,6,7,7,7,8,9,11,22,45,678,1000,1010,1100}
//        Нельзя использовать сортировку
        // 1 for 1 if , else

        int[] arr = {-5, 0, 1, 1, 2, 3, 6, 8, 22, 45, 678};
        int[] arr2 = {-10, 2, 3, 6, 7, 7, 7, 9, 11, 1000, 1010, 1100};
        int[] arr3 = twoArr(arr, arr2);

        System.out.println(Arrays.toString(arr3));

    }

    public static int[] twoArr(int[] one, int[] two) {

        int[] arr = new int[one.length + two.length];
        int i = 0, j = 0;

        for (int k = 0; k < arr.length; k++) {
            if (j >= two.length || (i < one.length && one[i] < two[j])) {
                arr[k] = one[i];
                i++;
            } else {
                arr[k] = two[j];
                j++;
            }
        }
        return arr;
    }
}