package lab2.ex6;

public class Ex6 {
    public static void main(String[] args) {
        twoQueue<Integer> list = new twoQueue<Integer>();
        list.enQueue(new Integer(-45));
        list.enQueue(new Integer(12));
        list.enQueue(new Integer(45));
        list.enQueue(new Integer(5));
        list.print();
        System.out.println();
        list.deQueue();
        list.print();
        System.out.println();
        System.out.println(list.getFront());
    }
}
