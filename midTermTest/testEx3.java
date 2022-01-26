import java.util.*;
public class testEx3 {
    public static int calculate(String[] expression){
        Stack<Integer> stack = new Stack<>();
        for(String s:expression){
            if(s.equals("+")){
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o2+o1);
            }
            if(s.equals("-")){
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o2-o1);
            }
            if(s.equals("/")){
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o2/o1);
            }
            if(s.equals("/")){
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o2/o1);
            }
            else if(isNumber(s)){
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    private static boolean isNumber(String str) {
        return str.matches("0|([1-9][0-9]*)");
    }

    public static void main(String[] args){
        // String[] s ={"3","4","+","2","1","+","-"};
        // System.out.println(calculate(s));
        // Stack<String> stack = new Stack<>();
        // Queue<String> queue = new LinkedList<>();
        // String txt = "256652";
        // if(Integer.parseInt(txt) > 0){
        //     System.out.println("ajs");
        // }
        // for(int i =0;i<txt.length();i++){
        //     String ch = txt.substring(i,i+1);
        //     stack.push(ch);
        //     queue.add(ch);
        // }
        // boolean check = false;
        // while(!stack.isEmpty()){
        //     if(stack.pop().equals(queue.poll())){
        //         check = true;
        //     }
        //     else{
        //         check = false;
        //         break;
        //     }
        // }
        // if(check){
        //     System.out.println("palind");
        // }
        // else{
        //     System.out.println("not palind");
        // }
        // Stack<String> stack = new Stack<String>();
        // String s ="I Like apple";
        // String[] ch = s.split(" ");
        // for(String e: ch ){
        //     stack.push(e);
        // }
        // while(!stack.isEmpty()){
        //     System.out.print(stack.pop()+" ");
        // }

        Stack<Integer> stack = new Stack<>();
        int dec = 14;
        while(dec!=0){
            stack.push(dec%2);
            dec/=2;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
