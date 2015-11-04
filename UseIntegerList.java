public class UseIntegerList {

    public static void main(String[] args) {
        IntegerList myList = new IntegerList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.remove(2);

        System.out.println("Contains 3 = " + myList.contains(3));
        System.out.println("isEmpty = " + myList.isEmpty());
        System.out.println("size = " + myList.size());

        myList.forEach(System.out::println);
        myList.clear();
    }
}
