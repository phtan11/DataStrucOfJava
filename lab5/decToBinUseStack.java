package stack;
import java.util.Stack;
public class decToBinUseStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        int num =50;
        while(num!=0){
            int d = num%2;
            stack.push(d);
            num /= 2;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
