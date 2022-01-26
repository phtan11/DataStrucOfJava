import java.util.Stack;
public class ex3{
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
            if(s.equals("*")){
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o2*o1);
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
        String[] s = {"3","4","+","2","1","+","-"};
        int a = calculate(s);
        System.out.println(a);
    }
}