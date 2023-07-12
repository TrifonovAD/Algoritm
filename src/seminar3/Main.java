package seminar3;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();

        list.add("7");
        list.add("2");
        list.add("Hello");
        list.add("World!");
        list.add("9");

        list.print();
        System.out.println();


//        list.remove(7);
//        System.out.println();
//        list.print();

//        list.removeAt(0);
//        System.out.println();
//        list.print();

//        System.out.println();
//        System.out.println(list.getValue(1));
//        System.out.println(list.getValue(5));

        list.addAt("12", 5);
        list.print();
        System.out.println();

//        list.clear();
//        list.print();
        list.quickSort();
        list.print();

    }
}
