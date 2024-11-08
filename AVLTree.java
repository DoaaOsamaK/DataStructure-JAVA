public class AVLTree {

    private class Node {
        int value;
        Node leftChild, rightChild;
        int height;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    // Returns the height of a node, or 0 if null
    private int getNodeHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Calculates the balance factor of a node
    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : getNodeHeight(node.leftChild) - getNodeHeight(node.rightChild);
    }

    // Performs a right rotation
    private Node performRightRotation(Node unbalancedNode) {
        Node leftChild = unbalancedNode.leftChild;
        Node rightSubtreeOfLeftChild = leftChild.rightChild;

        // Rotate
        leftChild.rightChild = unbalancedNode;
        unbalancedNode.leftChild = rightSubtreeOfLeftChild;

        // Update heights
        unbalancedNode.height = Math.max(getNodeHeight(unbalancedNode.leftChild), getNodeHeight(unbalancedNode.rightChild)) + 1;
        leftChild.height = Math.max(getNodeHeight(leftChild.leftChild), getNodeHeight(leftChild.rightChild)) + 1;

        return leftChild;
    }

    // Performs a left rotation
    private Node performLeftRotation(Node unbalancedNode) {
        Node rightChild = unbalancedNode.rightChild;
        Node leftSubtreeOfRightChild = rightChild.leftChild;

        // Rotate
        rightChild.leftChild = unbalancedNode;
        unbalancedNode.rightChild = leftSubtreeOfRightChild;

        // Update heights
        unbalancedNode.height = Math.max(getNodeHeight(unbalancedNode.leftChild), getNodeHeight(unbalancedNode.rightChild)) + 1;
        rightChild.height = Math.max(getNodeHeight(rightChild.leftChild), getNodeHeight(rightChild.rightChild)) + 1;

        return rightChild;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        // Perform regular BST insertion
        if (value < currentNode.value) {
            currentNode.leftChild = insertNode(currentNode.leftChild, value);
        } else if (value > currentNode.value) {
            currentNode.rightChild = insertNode(currentNode.rightChild, value);
        } else {
            return currentNode;
        }

        // Update height of current node
        currentNode.height = 1 + Math.max(getNodeHeight(currentNode.leftChild), getNodeHeight(currentNode.rightChild));

        // Get balance factor and perform rotations if needed
        int balanceFactor = getBalanceFactor(currentNode);

        // Left-heavy case
        if (balanceFactor > 1 && value < currentNode.leftChild.value) {
            return performRightRotation(currentNode);
        }

        // Right-heavy case
        if (balanceFactor < -1 && value > currentNode.rightChild.value) {
            return performLeftRotation(currentNode);
        }

        // Left-right case
        if (balanceFactor > 1 && value > currentNode.leftChild.value) {
            currentNode.leftChild = performLeftRotation(currentNode.leftChild);
            return performRightRotation(currentNode);
        }

        // Right-left case
        if (balanceFactor < -1 && value < currentNode.rightChild.value) {
            currentNode.rightChild = performRightRotation(currentNode.rightChild);
            return performLeftRotation(currentNode);
        }

        return currentNode;
    }

    // Pre-order traversal to print the tree structure
    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(Node currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.value + " ");
            preOrder(currentNode.leftChild);
            preOrder(currentNode.rightChild);
        }
    }
}
