package homework4;

public class RedBlackTree {

    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            return true;
        }
        Node newNode = addNode(root, value);
        if (newNode != null) {
            balanceTree(newNode);
            return true;
        }
        return false;

    }

    private Node addNode(Node node, int value) {
        if (node.value == value)
            return null;
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            } else
                return addNode(node.left, value);
        } else  {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            } else
                return addNode(node.right, value);
        }
    }
    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    // Балансировка дерева после вставки
    private void balanceTree(Node node) {
        if (node == root) {
            node.color = Color.black;
            return;
        }
        Node parent = getParentNode(node);
        if (parent == null || parent.color == Color.black) {
            return;
        }
        Node grandParent = getParentNode(parent);
        Node uncle = getUncleNode(node, parent, grandParent);
        if (uncle != null && uncle.color == Color.red) {
            swapColors(grandParent);
            balanceTree(grandParent);
            return;
        }
        if (parent == grandParent.left) {
            if (node == parent.right) {
                rotateLeft(parent);
                node = parent;
                parent = node.left;
            }
            rotateRight(grandParent);
        } else {
            if (node == parent.left) {
                rotateRight(parent);
                node = parent;
                parent = node.right;
            }
            rotateLeft(grandParent);
        }
        parent.color = Color.black;
        grandParent.color = Color.red;
    }

    // Метод для изменения цветов при балансировке
    private void swapColors(Node node) {
        node.color = Color.red;
        node.left.color = Color.black;
        node.right.color = Color.black;
    }

    // Метод для выполнения левого поворота
    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left = node;
        }
        rightChild.left = node;
        if (getParentNode(node) == null) {
            root = rightChild;
        } else if (node == getParentNode(node).left) {
            getParentNode(node).left = rightChild;
        } else {
            getParentNode(node).right = rightChild;
        }
    }

    // Метод для выполнения правого поворота
    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right = node;
        }
        leftChild.right = node;
        if (getParentNode(node) == null) {
            root = leftChild;
        } else if (node == getParentNode(node).left) {
            getParentNode(node).left = leftChild;
        } else {
            getParentNode(node).right = leftChild;
            }
    }

    // Метод для получения родительского узла
    private Node getParentNode(Node node) {
        Node parent = null;
        Node current = root;
        while (current != null && current != node) {
            parent = current;
            if (node.value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return parent;
    }

    // Метод для получения дяди узла
    private Node getUncleNode(Node node, Node parent, Node grandParent) {
        if (grandParent.left == parent) {
            return grandParent.right;
        } else {
            return grandParent.left;
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean isLast) {
        if (node != null) {
            System.out.print(indent);
            if (isLast) {
                System.out.print("└─");
                indent += "   ";
            } else {
                System.out.print("├─");
                indent += "|  ";
            }

            String nodeColor = (node.color == Color.red) ? "RED" : "BLACK";
            System.out.println(node.value + " (" + nodeColor + ")");

            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        public Node() {
            this.color = Color.red;
        }

        public Node(int _value) {
            this.value = _value;
            this.color = Color.red;
        }
    }
    enum Color { red, black }
}
