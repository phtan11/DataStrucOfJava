package lab2.ex2;

public class testEx2 {
    public static void main(String[] args) {
        myQueue<Fraction> list = new myQueue<Fraction>();
        list.enQueue(new Fraction(1,2));
        list.enQueue(new Fraction(2,3));
        list.enQueue(new Fraction(3,4));
        list.enQueue(new Fraction(4,5));
        list.print();
        System.out.println();
        list.deQueue();
        System.out.println("after dequeue:" + list.getFront());
        System.out.println("contains:" + list.contains(new Fraction(3,4)));
    }
}
