package main.java.info.stochastic.crackingthecodinginterview.arraysandstrings;

public class stringComprassion {
    static String compress(String s) {
        char cur = s.charAt(0);
        int counter = 0;
        s = s + (s.charAt(s.length() - 1) == 'a' ? 'b' : 'a');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (cur != s.charAt(i)) {
                sb.append(cur).append(counter);
                cur = s.charAt(i);
                counter = 1;
            } else {
                counter++;
            }
        }

        if (sb.length() < s.length() - 1) {
            return sb.toString();
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(compress("aaadddsssssss"));
        System.out.println(compress("aaa"));
        System.out.println(compress("acvbnm"));
        System.out.println(compress("aaaab"));
    }
}
