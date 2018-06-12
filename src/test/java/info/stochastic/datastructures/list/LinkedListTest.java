package test.java.info.stochastic.datastructures.list;

import main.java.info.stochastic.datastructures.list.LinkedList;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LinkedListTest {

    private LinkedList<Integer> list = new LinkedList<>();
    private java.util.LinkedList<Integer> javaList = new java.util.LinkedList<>();
    private final int N = 100000;

    @Test
    public void testRandom() {
        Random r = new Random(42);
        for (int i = 0; i < N; i++) {
            int value = r.nextInt(N);
            int op = javaList.size() > 0 ? r.nextInt(4)
                                         : r.nextInt(2);
            switch (op) {
                case 0:
                    list.addFirst(value);
                    javaList.addFirst(value);
                    break;
                case 1:
                    list.addLast(value);
                    javaList.addLast(value);
                    break;
                case 2:
                    list.removeFirst();
                    javaList.removeFirst();
                    break;
                case 3:
                    list.removeLast();
                    javaList.removeLast();
                    break;
            }

            assertEquals(list.size(), javaList.size());
            if (list.size() > 0) {
                assertEquals(list.getFirst(), javaList.getFirst());
                assertEquals(list.getLast(), javaList.getLast());
            }
        }
    }
}
