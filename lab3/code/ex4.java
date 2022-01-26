package code;
public class ex4 {
    //a
    public static int cauA(int n){
        if(n==0) return 1;
        return ((2*n + 1) + cauA(n-1));
    }
    //b
    public static int factorial(int n){
        if(n==0) return 1;
        else return n*factorial(n-1);
    }
    public static int cauB(int n){
        if(n==0) return 1;
        return factorial(n)+cauB(n-1); 
    }
    //c
    public static double cauC(int n){
        if(n==0) return 1;
        return (factorial(n)*cauC(n-1)); 
    }
    //e
    public static double cauE(int n){
        if(n==1) return 3;
        return (Math.pow(2,n) +Math.pow(n,2)+cauE(n-1));
    }
    public static void main(String[] args){
        System.out.println("cau a:" + cauA(3));
        System.out.println("cau b:" + cauB(4));
        System.out.println("cau c:" + cauC(3));
        System.out.println("cau e:" + cauE(3));
    }
}
