package lection3;


public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void addNode(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.nextNode = node;
            node.previousNode = tail;
            tail = node;
        }
    }
    public void addNode(int value, Node node) {
        Node next = node.nextNode;
        Node newNode = new Node();
        newNode.value = value;
        node.nextNode = newNode;
        newNode.previousNode = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previousNode = newNode;
            newNode.nextNode = next;
        }
    }

    public void deleteNode(Node node) {
        Node previous = node.previousNode;
        Node next = node.nextNode;
        if (previous == null) {
            next.previousNode = null;
            head = next;
        } else if (next == null) {
            previous.nextNode = null;
            tail = previous;
        } else {
                previous.nextNode = next;
                next.previousNode = previous;
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

    public class Node {
        int value;
        Node nextNode;
        Node previousNode;
    }

}
