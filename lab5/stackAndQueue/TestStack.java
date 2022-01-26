package stackAndQueue;
import java.util.*;

public class TestStack{
    public static void main(String[] args) {
        Stack <Integer > intStack = new Stack <Integer >();
        intStack.push(2);
        intStack.push(5);
        intStack.push(1);
    //     while(!intStack.isEmpty()){
    //         System.out.print(intStack.pop() + " ");
    //    }
       System.out.println("" + intStack.peek());
       System.out.println("" + intStack.pop());
       System.out.println("" + intStack.peek());
       Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while(!queue.isEmpty()){
            System.out.print(" " + queue.poll());
        }
    }
}
