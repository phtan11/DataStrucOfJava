package labDataStrucAndAl.lab1.ex4;

public class testEx4 {
    public static void main(String[] args){
        myDoubleLinkedList list = new myDoubleLinkedList();
        list.addFirst(4.6);
        list.addFirst(9.11);
        list.addFirst(7.17);
        list.addFirst(8.18);
        list.appends(12.33);
        list.printt();
        DoubleNode z = list.currentNode(7.17);
        System.out.println();
        list.removeList(z);
        list.printt();
    }
}
