package labDataStrucAndAl.lab1.ex3;

public class testEx3 {
    public static void main(String[] args){
        myLinkedList list =new myLinkedList();
        Integer a = new Integer(6);
        Integer b = new Integer(2);
        Integer c = new Integer(4);
        Integer d = new Integer(5);
        Integer e = new Integer(100);

        list.addFirst(a);
        list.addFirst(b);
        list.addFirst(c);
        list.addFirst(d);
        list.printt();
        int s = list.countEven();
        System.out.println();
        System.out.println("amount of even number:" +s);
        int z =list.countPrime();
        System.out.println("amount of prime number:" +z);
        System.out.print("add number before even number:");
        list.addBeforeFirstEven(e);
        list.printt();
        System.out.println();
        System.out.print("max number:");
        int maxx = list.MaxList();
        System.out.println(maxx);
        list.reverseList();
        list.printt();
        System.out.println();
        list.sortList();
        list.printt();
    }   
}
