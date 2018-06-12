package main.java.info.stochastic.crackingthecodinginterview.arraysandstrings;

public class detectPermutation {

    static void fill(int[] arr, String s) {
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
    }

    static boolean isPermutation(String s1, String s2) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        fill(arr1, s1);
        fill(arr2, s2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("fsdfsd", "fsdfsd"));
        System.out.println(isPermutation("abc", "bca"));
        System.out.println(isPermutation("aaaa", "aaaa"));
        System.out.println(isPermutation("ddd4", "aaa4"));
    }
}
