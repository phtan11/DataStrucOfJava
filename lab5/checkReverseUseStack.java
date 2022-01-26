import java.util.Stack;
public class checkReverseUseStack {
    public static void main(String[] args){
        Stack stack = new Stack();
        String txt ="abcasdcba";
        for(int i=0;i<txt.length();i++){
            String ch =txt.substring(i,i+1);
            stack.push(ch);
            // or: stack.push(txt.charAt(i));
        }
        String reverse = "";
        while(!stack.isEmpty()){
            reverse += stack.pop();
        }
        if(reverse.equals(txt)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
