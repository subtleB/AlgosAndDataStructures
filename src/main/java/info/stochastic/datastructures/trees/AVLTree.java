package main.java.info.stochastic.datastructures.trees;

public class AVLTree {

    private class Node {
        int value;
        int height;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    private int size = 0;

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int balance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private Node rightRotate(Node node) {
        Node newRoot = node.left;
        Node leftChildRight = newRoot.right;
        newRoot.right = node;
        node.left = leftChildRight;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    private Node leftRotate(Node node) {
        Node newRoot = node.right;
        Node rightChildLeft = newRoot.left;
        newRoot.left = node;
        node.right = rightChildLeft;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            size++;
            return new Node(value);
        }

        // No duplicates allowed
        if (value == node.value) {
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        updateHeight(node);

        int balance = balance(node);

        // Balanced property was not violated
        if (balance < 2 && balance > -2) {
            return node;
        }

        if (balance > 1) {
            // Left left
            if (value < node.left.value) {
                return rightRotate(node);

            // Left right
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else {
            // Right right
            if (value > node.right.value) {
                return leftRotate(node);

            // Right left
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public boolean contains(int value) {
        Node cur = root;
        while (cur != null) {
            if (value == cur.value) {
                return true;
            }

            if (value < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    // For testing purposes
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (Math.abs(height(node.left) - height(node.right)) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public int getSize() {
        return size;
    }
}










