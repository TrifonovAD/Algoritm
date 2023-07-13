package seminar3;

public class LinkedList<T extends Comparable<T>> {

    private Node root;
    private int size;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value);
        size++;
    }

    public void addAt(T value, int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
            size++;
            return;
        }
        Node currentNode = getNode(index - 1);
        Node newNode = new Node(value, currentNode.next);
        currentNode.next = newNode;
        size++;
    }

    public boolean remove(T value) {
        if (root == null) {
            return false;
        }
        if (root.value.compareTo(value) == 0) {
            root = root.next;
            size--;
            return true;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;

    }
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }
        Node currentNode = getNode(index - 1);
        currentNode.next = currentNode.next.next;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 > size)
            return;
        if (index2 < 0 || index2 > size)
            return;
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public void quickSort() {
        quickSort(0, size-1);
    }

    private void quickSort(int startPosition, int endPosition) {
        T pivot = getValue((startPosition + endPosition) / 2);

        int leftPosition = startPosition;
        int rightPosition = endPosition;


        while (leftPosition <= rightPosition) {

            while (getValue(leftPosition).compareTo(pivot) < 0) {
                leftPosition++;
            }

            while (getValue(rightPosition).compareTo(pivot) > 0) {
                rightPosition--;
            }

            if (leftPosition <= rightPosition) {
                swap(leftPosition,rightPosition);
                leftPosition++;
                rightPosition--;
            }

        }

        if (leftPosition < endPosition) {
            quickSort(leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(startPosition, rightPosition);
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }
    public T getValue(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует");
        }
        Node currentNode = root;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return root;
        }
        Node currentNode = root;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    public void print() {
        if (root == null) {
            System.out.println("List is empty!");
            return;
        }
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }

    public void reverse() {
        Node prevNode = null;
        Node currentNode = root;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        root = prevNode;
    }

    private class Node {
        T value;
        Node next;
        Node() {}
        Node(T _value) { this.value = _value; }
        Node(T _value, Node _next) { this.value = _value; this.next = _next; }
    }
}
