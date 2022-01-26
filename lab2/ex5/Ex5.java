package lab2.ex5;

public class Ex5 {
    public static boolean determines(String s ){
        myStack<Character> stack = new myStack<Character>();
        char first;
        for(int i = 0; i < s.length(); i++){
            first = s.charAt(i);
            if(first == '{' || first == '[' || first == '('){
                stack.push(first);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char last = stack.getPeek();
                if((last == ')' && last == '(') || (last == ']' && last == '[')|| (last == '}' && last == '{')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    } 
    public static void main(String[] args){
        String s1 = "{][})";
        System.out.println(s1);
        System.out.println(determines(s1));
        String s2 = "({[}";
        System.out.println(s2);
        System.out.println(determines(s2));
    }
}
