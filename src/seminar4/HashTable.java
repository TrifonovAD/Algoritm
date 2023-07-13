package seminar4;

public class HashTable<K, V> {
    private static final double LOAD_SIZE=0.75;
    private static final double RESIZE_COEFFICIENT = 1.5;
    private int size;
    private List<K, V> [] lists;

    public HashTable() {
        this(4);
    }

    public HashTable(int _size) {
        if (_size < 4)
            lists = new List[4];
        else
            lists = new List[_size];
        size = 0;
    }

    public boolean add(K key, V value) {
        if (lists.length  * LOAD_SIZE <= size)
            resize();
        int index = calculateIndex(key);
        List<K, V> list = lists[index];
        if (list == null) {
            list = new List<>();
            lists[index] = list;
        }
        boolean added = list.add(key, value);
        if (added)
            size++;
        return added;
    }

    public boolean remove(K key) {
        int index = calculateIndex(key);
        List<K, V> list = lists[index];
        if (list == null)
            return false;
        boolean removed = list.remove(key);
        if (removed)
            size--;
        return removed;
    }
    
    public void print() {
        for (var item : lists) {
            if (item != null) {
                item.print();
                System.out.println();
            } else {
                System.out.println("--null--");
            }
        }
    }

    private void resize() {
        List <K, V> [] oldLists = lists;
        lists = new List[(int)(oldLists.length * RESIZE_COEFFICIENT)];
        for (int i = 0; i < oldLists.length; i++) {
            List<K, V> list = oldLists[i];
            if (list == null)
                continue;
            List.Node currentNode = list.root;
            while (currentNode != null) {
                this.add((K)currentNode.entity.key, (V)currentNode.entity.value);
                currentNode = currentNode.next;
            }
            oldLists[i] = null;
        }
        oldLists = null;
    }

    private int calculateIndex(K key) {
        return Math.abs(key.hashCode() % lists.length);
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return lists.length;
    }

    public V getValue(K key) {
        int index = calculateIndex(key);
        List<K, V> list = lists[index];
        return list.getValue(key);
    }


    private class List<K, V> {
        Node root;

        private boolean add(Entity entity) {
            Node newNode = new Node();
            newNode.entity = entity;
            if (root == null) {
                root = newNode;
                return true;
            }
            Node currentNode = root;
            while (currentNode != null) {
                if (currentNode.entity.key.equals(entity.key))
                    return false;
                if (currentNode.next == null) {
                    currentNode.next = newNode;
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }

        public boolean add(K key, V value) {
            Entity entity = new Entity(key, value);
            return this.add(entity);
        }

        public boolean remove(K key) {
            if (root == null)
                return false;
            if (root.entity.key == key) {
                root = root.next;
                return true;
            }
            Node currentNode = root;
            while (currentNode.next != null) {
                if (currentNode.next.entity.key.equals(key)) {
                    currentNode.next = currentNode.next.next;
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }

        private V getValue(K key) {
            Node currentNode = root;
            while (currentNode != null) {
                if (currentNode.entity.key.equals(key))
                    return currentNode.entity.value;
                currentNode = currentNode.next;
            }
            return null;
        }

        public boolean setValue(K key, V value) {
            Node currentNode = root;
            while (currentNode != null) {
                if (currentNode.entity.key.equals(key)) {
                    currentNode.entity.value = value;
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }
        private void print() {
            Node currentNode = root;
            while (currentNode != null){
                System.out.print("[" + currentNode.entity.key + ": " + currentNode.entity.value + "] ");
                currentNode = currentNode.next;
            }
        }

        private class Node {

            Entity entity;
            Node next;

        }

        private class Entity {
            K key;
            V value;

            Entity() {
            }

            Entity(K _key, V _value) {
                this.key = _key;
                this.value = _value;
            }
        }
    }
}
