package Testt;

public class maun {
    public static void main(String[] args){
        IntLinkedList list = new IntLinkedList();
        list.addFirst(1);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(9);
        list.addFirst(12);
        list.addAfterFirstKey(77,4);
        list.printla();
        System.out.println();
        System.out.println(list.getHead());
    }
}
