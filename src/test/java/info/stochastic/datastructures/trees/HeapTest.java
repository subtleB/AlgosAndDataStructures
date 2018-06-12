package test.java.info.stochastic.datastructures.trees;
import static org.junit.jupiter.api.Assertions.assertEquals;
import main.java.info.stochastic.datastructures.trees.Heap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

@RunWith(JUnit4.class)
public class HeapTest {

    private PriorityQueue<Integer> q = new PriorityQueue<>();
    private Heap<Integer> heap = new Heap<>(Comparator.comparingInt(x -> x));

    @Test
    public void testHeap() {
        Random r = new Random(System.currentTimeMillis());
        int iterations = 10000;

        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < iterations; j++) {
                int next = r.nextInt();
                q.add(next);
                heap.add(next);
                peekTest();
                sizeTest();
            }

            for (int j = 0; j < iterations; j++) {
                pollTest();
                peekTest();
                sizeTest();
            }
        }
    }

    @Test
    public void testHeapRandomOperation() {
        Random r = new Random(System.currentTimeMillis());
        int iterations = 1000000;

        for (int i = 0; i < 100; i++) {
            int value = r.nextInt();
            q.add(value);
            heap.add(value);
        }

        for (int i = 0; i < iterations; i++) {
            boolean next = r.nextBoolean();

            if (next) {
                int value = r.nextInt();
                q.add(value);
                heap.add(value);
            } else {
                pollTest();
            }
            peekTest();
            sizeTest();
        }
    }

    public void peekTest() {
        assertEquals(q.peek(), heap.peek());
    }

    public void sizeTest() {
        assertEquals(q.size(), heap.size());
    }

    public void pollTest() {
        assertEquals(q.poll(), heap.poll());
    }
}
