package main.java.info.stochastic.algorithms.sorting;

public class QuickSort {
    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void qSort(int arr[], int l, int r) {

        if (r - l <= 1) {
            return;
        }

        //int pivot = arr[l];

        //int pivot = arr[r - 1];
        //swap(arr, l, r - 1);

        int m = (r + l) / 2 + ((r + l) % 2 == 0 ? -1 : 0);
        int left = arr[l];
        int right = arr[r - 1];
        int mid = arr[m];

        int pivot;
        if ((left > mid && left < right) || (left < mid && left > right)) {
            pivot = left;
        } else if ((right > mid && right < left) || (right < mid && right > left)) {
            pivot = right;
            swap(arr, l, r - 1);
        } else {
            pivot = mid;
            swap(arr, l, m);
        }

        int partition = l + 1;
        for (int i = l + 1; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, partition++);
            }
        }

        swap(arr, l, partition - 1);

        qSort(arr, l, partition - 1);
        qSort(arr, partition, r);
    }

}
