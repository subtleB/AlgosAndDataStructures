package main.java.info.stochastic.crackingthecodinginterview.dpandresursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allPermutations {

    static List<List<Integer>> compute(List<Integer> source) {
        List<List<Integer>> result = new ArrayList<>();
        if (source.size() == 1) {
            result.add(source);
            return result;
        }

        int next = source.get(source.size() - 1);
        source.remove(source.size() - 1);
        
        List<List<Integer>> tmp = compute(source);

        for (List<Integer> list: tmp) {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> newList = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) newList.add(next);
                    newList.add(list.get(j));
                }
                result.add(newList);
            }
            list.add(next);
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        for (List<Integer> list: compute(a)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
