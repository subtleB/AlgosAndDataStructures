package main.java.info.stochastic.crackingthecodinginterview.arraysandstrings;

public class stringHasAllUniqChars {

    static boolean solve(String s) {
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] > 0) {
                return false;
            }
            chars[s.charAt(i)] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve("fsdfsd"));
        System.out.println(solve("abc"));
        System.out.println(solve("ddsdfghj"));
        System.out.println(solve("342fdse3"));
    }

}
