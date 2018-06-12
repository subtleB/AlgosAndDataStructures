package main.java.info.stochastic.crackingthecodinginterview.arraysandstrings;

public class rotateMatrix {

    static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    static void swapElements(int[][] arr, int i, int j) {
        int n  = arr.length - 1;
        swap(arr, i, j, n - j, i);
        swap(arr, n - j, i, n - i, n - j);
        swap(arr, n - i, n - j, j, n - i);
    }

    static void rotate(int[][] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                swapElements(arr, j, i);
            }
        }
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] arr3 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        int[][] arr4 = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4},
        };

        int[][] arr5 = {
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3},
            {4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5},
        };

        rotate(arr5);
        rotate(arr5);
        rotate(arr5);
        rotate(arr5);
        print(arr5);
    }
}
