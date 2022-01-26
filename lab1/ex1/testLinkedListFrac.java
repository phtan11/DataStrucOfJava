package labDataStrucAndAl.lab1.ex1;

import labDataStrucAndAl.lab1.ex2.myLinkedList;

public class testLinkedListFrac {
    public static void main(String[] args){
        myLinkedList <Fraction> list = new myLinkedList<Fraction>();
        Fraction x=new Fraction(1,2);
        Fraction y=new Fraction(2,3);
        Fraction z=new Fraction(3,5);
        list.addFirst(x);
        list.addFirst(y);
        list.addFirst(z);
        list.print();
        System.out.println();
        list.removeFirst();
        list.print();
        System.out.println();
        Fraction w = new Fraction(1,2);
        if(list.contains(w))
            w=y;
        list.addFirst(w);
        list.print();
    }   
}
