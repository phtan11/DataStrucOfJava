import java.util.*;
public class palin{
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();
        String txt = "132231";
        boolean check =true;
        for(int i=0;i<txt.length();i++) {
            String ch = txt.substring(i,i+1);
            stack.push(ch);
            queue.add(ch);
        }
        while(!stack.isEmpty() && check==true) {
           if(!stack.pop().equals(queue.poll())) {
                check=false;
            } 
        }
        if(check){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }   
}