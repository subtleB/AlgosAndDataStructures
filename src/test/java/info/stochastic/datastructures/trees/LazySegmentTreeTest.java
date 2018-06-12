package test.java.info.stochastic.datastructures.trees;

import main.java.info.stochastic.datastructures.trees.LazySegmentTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LazySegmentTreeTest {

    private final int N = 100;
    private int[] a = new int[N];
    private LazySegmentTree st = new LazySegmentTree(a);

    private int getSum(int l, int r) {
        int sum = 0;
        for (int i = l; i < r; i++) {
            sum += a[i];
        }
        return sum;
    }

    private void updateRange(int l, int r, int diff) {
        for (int i = l; i < r; i++) {
            a[i] += diff;
        }
    }

    @Test
    public void testRandom() throws Exception {
        Random r = new Random(42);
        for (int i = 0; i < N; i++) {
            int left = 1;
            int right = 0;
            while (left >= right) {
                left = r.nextInt(N);
                right = r.nextInt(N);
            }

            int diff = r.nextInt(N) - N / 2;

            st.updateRange(left, right, diff);
            updateRange(left, right, diff);

            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    assertEquals(st.getSum(i, j), getSum(i, j));
                }
            }
        }
    }

}
