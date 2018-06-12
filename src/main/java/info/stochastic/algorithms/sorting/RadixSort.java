package main.java.info.stochastic.algorithms.sorting;

public class RadixSort {

    private int getMaxElement(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int ai : a) {
            max = Math.max(max, ai);
        }
        return max;
    }

    private void countingSort(int[] a, int exp) {
        int n  = a.length;
        int[] counts = new int[10];
        int[] output = new int[n];

        for (int ai : a) {
            counts[(ai / exp) % 10]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[counts[(a[i] / exp) % 10] - 1] = a[i];
            counts[(a[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, a, 0, n);
    }

    public void radixSort(int[] a) {
        int max = getMaxElement(a);
        int exp = 1;

        while (max > 0) {
            max /= 10;
            countingSort(a, exp);
            exp *= 10;
        }
    }
}
