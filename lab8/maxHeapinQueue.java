import java.util.*;
public class maxHeapinQueue{
    public static void main(String[] args){
        priorityQueue queue = new priorityQueue(100);
        queue.enQueue(new person("Alex", 3));
        queue.add("Bob", 2);
        queue.add("David", 6);
        queue.add("Susan", 1);
        System.out.println(queue.dequeue());
    }
    //ket qua 4 dequeue la: david 6 - mike 5-kavin 4 - paul 8
}