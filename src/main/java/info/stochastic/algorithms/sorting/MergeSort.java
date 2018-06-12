package main.java.info.stochastic.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] source) {
        int n = source.length;
        int[] helper = new int[n];

        // Merge parts of size i
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j += i * 2) {

                // Copy elements of the current window
                for (int k = j; k < j + i * 2 && k < n; k++) {
                    helper[k] = source[k];
                }

                // Merge elements in the current window
                int left = j;
                int right = j + i;
                for (int k = j; k < j + i * 2 && k < n; k++) {

                    if (left >= j + i) {
                        source[k] = helper[right++];
                        continue;
                    }

                    if (right >= j + i * 2 || right >= n) {
                        source[k] = helper[left++];
                        continue;
                    }

                    if (helper[left] > helper[right]) {
                        source[k] = helper[right++];
                    } else {
                        source[k] = helper[left++];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 6, 3, 4, 8, 7};
        int[] a1 = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        int[] a2 = new int[]{8, 7, 6, 5, 1, 2, 3, 4};

        int[] b = new int[]{1, 2, 3};
        int[] b1 = new int[]{2, 3, 1};
        int[] b2 = new int[]{3, 2, 1};
        int[] b3 = new int[]{3, 1, 2};

        int[] c = new int[]{1, 2, 5, 6, 3, 9, 4, 8, 7};
        int[] c1 = new int[]{8, 7, 6, 5, 4, 3, 2, 1, 9};
        int[] c2 = new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4};


        mergeSort(a);
        mergeSort(a1);
        mergeSort(a2);
        mergeSort(c);
        mergeSort(c1);
        mergeSort(c2);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(c2));

    }
}
