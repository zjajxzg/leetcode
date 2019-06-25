package exercise.swordoffer._013;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray1(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++ ) {
                if (array[i] % 2 == 0) {
                    if (array[j] % 2 == 1) {
                        int temp;
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        break;
                    }

                }
            }

        }
    }

    public static void reOrderArray2(int[] array) {
        int[] a = new int[array.length];
        int index = 0;
        for (int i = 0; i< array.length; i++) {
            if (array[i] % 2 == 1) {
                a[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                a[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray2(a);
        System.out.println(Arrays.toString(a));
    }
}
