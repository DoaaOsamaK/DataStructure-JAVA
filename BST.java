public class BST {

    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    
    private Node root;

    public Node add(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val > root.val) {
            root.right = add(root.right, val);
        } else if (val < root.val) {
            root.left = add(root.left, val);
        }
        return root;
    }

    public void add(int val) {
        root = add(root, val);
    }

    private void printInOrder(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        printInOrder(root.left, sb);
        sb.append(root.val).append(" ");
        printInOrder(root.right, sb);
    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private Node remove(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = remove(root.left, val);
        } else if (val > root.val) {
            root.right = remove(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = findMinValue(root.right);
            root.right = remove(root.right, root.val);
        }
        return root;
    }

    private int findMinValue(Node root) {
        int min = root.val;
        while (root.left != null) {
            root = root.left;
            min = root.val;
        }
        return min;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        printInOrder(root, sb);
        sb.setLength(sb.length() - 1); // Remove the trailing space
        sb.append("]");
        return sb.toString();
    }
}
