package main.java.info.stochastic.crackingthecodinginterview.arraysandstrings;

public class replaceSpaces {
    static String replace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString().substring(0, s.length());
    }

    public static void main(String[] args) {
        System.out.println(replace("dsd ds s dsds      "));
        System.out.println(replace("dsd ds  "));
        System.out.println(replace("dsd"));
    }
}
