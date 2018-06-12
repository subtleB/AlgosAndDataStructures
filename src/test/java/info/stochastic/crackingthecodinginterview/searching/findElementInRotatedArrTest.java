package test.java.info.stochastic.crackingthecodinginterview.searching;

import main.java.info.stochastic.crackingthecodinginterview.Searching.findElementInRotatedArr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class findElementInRotatedArrTest {
    Random r = new Random(32);

    private void rotate(int[] a, int rotation) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(i + rotation) % a.length] = a[i];
        }
        System.arraycopy(b, 0, a, 0, a.length);
    }

    @Test
    public void findElementInRotatedTest() throws Exception {
        findElementInRotatedArr search = new findElementInRotatedArr();

        int a[] = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for (int i = 0; i < a.length; i++) {
            rotate(a, 1);

            for (int element : a) {
                assertEquals(element, a[search.findElementInRotatedArr(a, element)]);
            }
        }

    }
}
