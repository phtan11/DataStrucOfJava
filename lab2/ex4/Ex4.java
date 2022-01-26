package lab2.ex4;

public class Ex4 {
    public static String Reverse(String str){
        myStack<Character> list = new myStack<Character>();
        for (int i = 0; i < str.length(); i++) {
            list.push(str.charAt(i));
        }
        String rev = "";
        while(!list.isEmpty()){
            rev += list.pop();
        }
        return rev;
    }
    public static void main(String[] args){
        String s  = "pham phuoc tan";
        System.out.println(s);
        System.out.println(Reverse(s));
    }
}
