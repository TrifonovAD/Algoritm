package seminar4;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("hello", 1);
        table.add("world", 2);
        table.add("privet", 3);
        table.add("mir", 4);
        table.add("key", 5);
        table.add("bye", 6);
        table.add("bye1", 7);
        table.add("bye2", 8);
        table.add("bye3", 9);
        table.add("bye4", 10);
        table.add("zdraste", 11);
        table.add("poka", 12);
        table.print();
        System.out.println(table.getValue("key"));
        System.out.println(table.getSize());
        System.out.println(table.getLength());
    }
}

