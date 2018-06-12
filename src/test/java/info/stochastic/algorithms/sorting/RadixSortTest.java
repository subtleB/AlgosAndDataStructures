package test.java.info.stochastic.algorithms.sorting;

import main.java.info.stochastic.algorithms.sorting.RadixSort;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RadixSortTest {

    private Method countingSort;
    private RadixSort rs = new RadixSort();

    private boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    @Before
    public void setUp() throws Exception {
        countingSort = RadixSort.class.getDeclaredMethod("countingSort", int[].class, int.class);
        countingSort.setAccessible(true);
    }

    @Test
    public void countingSortDigits() throws Exception {
        int[] a = new int[]{5, 2, 1, 0, 6, 8, 9, 2, 4, 2, 3, 5, 2, 3, 7};
        countingSort.invoke(rs, a, 1);
        assertTrue(isSorted(a));
    }

    @Test
    public void radixSortTest() throws Exception {
        int[] a = new int[]{5, 2, 1, 0, 6, 8, 9, 2, 4, 2, 3, 5, 2, 3, 7};
        rs.radixSort(a);
        assertTrue(isSorted(a));

        a = new int[]{1000, 100, 10, 1, 0};
        rs.radixSort(a);
        assertTrue(isSorted(a));

        a = new int[]{1500, 1400, 1300, 1200, 1100};
        rs.radixSort(a);
        assertTrue(isSorted(a));

        a = new int[]{3500, 2400, 1300, 1200, 1100};
        rs.radixSort(a);
        assertTrue(isSorted(a));

        a = new int[]{3510, 2, 2420, 1330, 1, 1240, 1199, 100000};
        rs.radixSort(a);
        assertTrue(isSorted(a));
    }

    @Test
    public void radixSortRandomTest() throws Exception {
        int[] a = new int[100];

        Random r = new Random(System.currentTimeMillis());
        for (int iter = 0; iter < 10000; iter++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = Math.abs(r.nextInt());
            }
            rs.radixSort(a);
            assertTrue(isSorted(a));
        }
    }

}
