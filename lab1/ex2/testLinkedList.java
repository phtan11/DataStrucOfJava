package labDataStrucAndAl.lab1.ex2;

public class testLinkedList {
    public static void main(String[] args){
        myLinkedList <Integer> list =new myLinkedList<Integer>();
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        Integer c = new Integer(3);
        Integer d = new Integer(4);
        
        list.addFirst(a);
        list.addFirst(b);
        list.addFirst(c);
        list.addFirst(d);
        Node <Integer> curr = list.currentNode(b);
        Node <Integer> pre = list.previousNode(b);
        list.removeCurr(curr, pre);
        list.print();
    }
}
