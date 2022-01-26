package stackAndQueue;
import java.util.*;
public class ex3 {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        String txt = "I like apple";
        String[] tach = txt.split(" ");
        for(String s : tach){
            stack.push(s);
        }
        while(!stack.isEmpty()){
            System.out.print(" " + stack.pop());
        }
    }
}
