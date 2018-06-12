package main.java.info.stochastic.datastructures.trees;

public class LazySegmentTree {

    private int[] tree;
    private int[] lazy;
    private int n;

    public LazySegmentTree(int[] arr) {
        n = arr.length;

        // Height of the tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        // Maximum size of the tree
        int maxSize = 2 * (int) Math.pow(2, x) - 1;
        tree = new int[maxSize];
        lazy = new int[maxSize];
        constructTree(arr, 0, n, 0);
    }

    private int constructTree(int[] source, int l, int r, int index) {
        if (r - l == 1) {
            tree[index] = source[l];
            return source[l];
        }

        int mid = (l + r) >>> 1;
        tree[index] = constructTree(source, l, mid, index * 2 + 1)
                    + constructTree(source, mid, r, index * 2 + 2);
        return tree[index];
    }

    private void lazyUpdate(int index, int l, int r) {
        tree[index] += (r - l) * lazy[index];
        if (r - l != 1) {
            lazy[index * 2 + 1] = lazy[index];
            lazy[index * 2 + 2] = lazy[index];
        }
        lazy[index] = 0;
    }

    public int getSum(int queryL, int queryR) {
        return getSum(0, n, queryL, queryR, 0);
    }

    private int getSum(int l, int r, int queryL, int queryR, int index) {
        if (lazy[index] != 0) {
            lazyUpdate(index, l, r);
        }

        if (l >= queryL && r <= queryR) {
            return tree[index];
        }

        if (l >= queryR || r <= queryL) {
            return 0;
        }

        int mid = (l + r) >>> 1;
        return getSum(l, mid, queryL, queryR, index * 2 + 1)
                + getSum(mid, r, queryL, queryR, index * 2 + 2);
    }

    public void updateRange(int l, int r, int diff) {
        updateRange(0, n, l, r, diff, 0);
    }

    private void updateRange(int l, int r, int updL, int updR, int diff, int index) {
        if (lazy[index] != 0) {
            lazyUpdate(index, l, r);
        }

        if (l >= updR || r <= updL) {
            return;
        }

        if (l >= updL && r <= updR) {
            tree[index] += (r - l) * diff;
            if (r - l != 1) {
                lazy[index * 2 + 1] += diff;
                lazy[index * 2 + 2] += diff;
            }
            return;
        }

        int mid = (l + r) >>> 1;
        updateRange(l, mid, updL, updR, diff,index * 2  + 1);
        updateRange(mid, r, updL, updR, diff, index * 2  + 2);
        tree[index] = tree[index * 2 + 1] + tree[index * 2 + 2];
    }
}
