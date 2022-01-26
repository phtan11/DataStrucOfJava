package lab2.ex3;
import java.lang.Math;

public class Ex3 {
    public static int Stack(int n){
        myStack<Integer> stack = new myStack<Integer>();
        while(n>1){
            int result = (int)(Math.pow(2,n)+Math.pow(n,2));
            stack.push(result);
            n--;
        }
        int s =0;
        while(!stack.isEmpty()){
            s += stack.pop();
        }
        return s+3;
    }
    public static int Recursion(int n){ 
        if(n==1) return 3;
        else return (int)(Math.pow(2,n)+Math.pow(n,2) + Recursion(n-1));
    }
    public static void main(String[] args){
        System.out.println(Stack(3));
        int s = Recursion(3);
        System.out.println(s);
    }
}
