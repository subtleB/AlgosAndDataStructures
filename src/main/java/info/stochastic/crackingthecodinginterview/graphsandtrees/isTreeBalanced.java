package main.java.info.stochastic.crackingthecodinginterview.graphsandtrees;

public class isTreeBalanced {

    int depth(BTreeNode node) {
        if (node == null) return 0;

        Integer left =  depth(node.left);
        Integer right = depth(node.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    boolean checkTreeBalance(BTreeNode node) {
        return depth(node) != -1;
    }
}
