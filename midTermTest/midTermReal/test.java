public class test {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(6);
        list.addFirst(1);
        System.out.println(list.getHead());
        System.out.println(list.countElementSmallerThanKey(5));
       
    }
}
