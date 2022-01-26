import java.util.Stack;
public class Question2 {
    public static String reverseIntList(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int s:arr){
            stack.push(s);
        }
        String s ="";
        while(!stack.isEmpty()){
            s += stack.pop();
        }
        return s;
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        System.out.println(reverseIntList(a));
    }
}
