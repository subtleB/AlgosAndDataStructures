package main.java.info.stochastic.datastructures.trees;

public class SegmentTree {

    private int[] tree;
    private int[] values;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        values = new int[n];
        System.arraycopy(arr, 0, values, 0, arr.length);

        // Height of the tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        // Maximum size of the tree
        int maxSize = 2 * (int) Math.pow(2, x) - 1;
        tree = new int[maxSize];
        constructTree(arr, 0, n, 0);
    }

    private int constructTree(int[] source, int l, int r, int index) {
        if (r - l == 1) {
            tree[index] = source[l];
            return source[l];
        }

        int mid = ((l + r) >>> 1);
        tree[index] = constructTree(source, l, mid, index * 2 + 1)
                    + constructTree(source, mid, r, index * 2 + 2);
        return tree[index];
    }

    public int getSum(int queryL, int queryR) {
        return getSum(0, n, queryL, queryR, 0);
    }

    private int getSum(int l, int r, int queryL, int queryR, int index) {
        if (l >= queryL && r <= queryR) {
            return tree[index];
        }

        if (l >= queryR || r <= queryL) {
            return 0;
        }

        int mid = ((l + r) >>> 1);
        return getSum(l, mid, queryL, queryR, index * 2 + 1)
                + getSum(mid, r, queryL, queryR, index * 2 + 2);
    }

    public void update(int index, int value) {
        update(0, n, value - values[index], index, 0);
        values[index] = value;
    }

    private void update(int l, int r, int diff, int qIndex, int index) {
        if (l > qIndex || r <= qIndex) {
            return;
        }

        tree[index] += diff;

        if (r - l == 1) {
            return;
        }

        int mid = ((l + r) >>> 1);
        update(l, mid, diff, qIndex, index * 2  + 1);
        update(mid, r, diff, qIndex, index * 2  + 2);
    }
}
