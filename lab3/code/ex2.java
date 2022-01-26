package code;
public class ex2 {
    //a
    public static int factorial(int n){
        if(n==0) return 1;
        else return n*factorial(n-1);
    }
    //b
    public static double computer(int x,int n){
        if(n==1) return Math.pow(x,1);
        else return (Math.pow(x,n) + computer(x,n-1));
    }
    //c
    public static int countt(int n){
        if(n/10 == 0) return 1;
        return 1+countt(n/10); 
    }
    public static void main(String[] args){
        System.out.println("cau a:" +factorial(4));
        System.out.println("cau b:" + computer(2,2));
        System.out.println("cau c:" +countt(123));
    }
}
