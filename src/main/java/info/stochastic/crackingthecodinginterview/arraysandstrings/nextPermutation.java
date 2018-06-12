package main.java.info.stochastic.crackingthecodinginterview.arraysandstrings;

import java.util.Arrays;

public class nextPermutation {

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static boolean nextPermutation(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[i] >= a[j]) {
            j--;
        }

        swap(a, i, j);

        int l = i + 1;
        int r = a.length - 1;
        while (l < r) {
            swap(a, l++, r--);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};

        do {
            System.out.println(Arrays.toString(a));
        } while (nextPermutation(a));
    }
}
