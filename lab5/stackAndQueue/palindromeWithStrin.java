package stackAndQueue;
import java.util.*;
public class palindromeWithStrin {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();
        String txt = "256652";
        for(int i = 0;i<txt.length();i++){
            String ch = txt.substring(i,i+1);
            stack.push(ch);
            queue.offer(ch);
        }
        boolean check = true;
        while(!stack.isEmpty() && check) {
            if(!stack.pop().equals(queue.poll())) {
                check = false;
            }
        }
        if(check){
            System.out.println("a palindrome!");
        }
        else{
            System.out.println("isn't a palindrome!");
        }
    }
}
