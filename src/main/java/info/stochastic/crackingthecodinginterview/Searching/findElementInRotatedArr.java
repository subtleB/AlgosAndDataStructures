package main.java.info.stochastic.crackingthecodinginterview.Searching;

public class findElementInRotatedArr {

    private int binarySearchFindRotation(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > a[a.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int binarySearch(int[] a, int target, int rotation) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int index = (mid + rotation) % a.length;
            if (a[index] == target) {
                return index;
            } else if (a[index] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findElementInRotatedArr(int[] a, int target) {
        int rotation = binarySearchFindRotation(a);
        return binarySearch(a, target, rotation);
    }
}
