package lab2.ex1;

public class testStack {
    public static void main(String[] args){
        stackLL <Fraction> stack = new stackLL<Fraction>();
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction(2,3);
        Fraction c = new Fraction(3,4);
        Fraction d = new Fraction(4,5);
        stack.push(a);
        stack.push(b);
        stack.push(c);
        stack.print();
        System.out.println("top of stack is " + stack.getPeek());
        System.out.println("top of stack is " + stack.pop());
		stack.push(d);
        System.out.println("top of stack is " + stack.getPeek());
		stack.pop();
		stack.pop();
		System.out.println("top of stack is " + stack.getPeek());
    }
}
