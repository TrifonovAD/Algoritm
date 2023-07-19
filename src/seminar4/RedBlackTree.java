package seminar4;

public class RedBlackTree {

    public class Node {
        int value;
        Node leftChild;
        Node rigtChild;
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
