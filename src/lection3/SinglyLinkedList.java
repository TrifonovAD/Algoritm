package lection3;


public class SinglyLinkedList {
    private Node head;

    public void addNode(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }

    }

    public void addNode(int value, Node node) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.nextNode = node.nextNode;
        node.nextNode = newNode;
    }

    public void deleteNode(Node node) {
        if (head != null) {
            return;
        }
        if (head == node) {
            head = head.nextNode;
        } else {
            Node currentNode = head;
            while (currentNode.nextNode != null || currentNode.nextNode != node) {
                currentNode = currentNode.nextNode;
            }
            if (currentNode.nextNode == null) {
                return;
            }
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }

    }

    public Node findNode(int value) {
        Node node = head;
        while (node.nextNode != null) {
            if (node.value == value) {
                return node;
            }
        }
        return null;

    }

    private class Node {
        int value;
        Node nextNode;



    }

}
