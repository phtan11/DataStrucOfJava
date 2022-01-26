package ex1;

public class test {
    public static void main(String[] args){
        IntLinkedList list =new IntLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(9);
        list.addFirst(7);
        list.addFirst(15);
        list.print();
        System.out.println(list.getHead());
        list.addLast(77);
        list.addAfterFirstKey(78,77);
        System.out.println(list.sumOdd());
        list.print();
    }
}
