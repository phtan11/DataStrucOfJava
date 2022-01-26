package recursion;

public class ex2 {
    public static float GT(int n){
        if(n==0) return 1;
        else return n*GT(n-1);
    }
    public static int cauA(int n){
        if(n==1) return 2;
        return (int)(Math.pow(2,n)+cauA(n-1));
    }
    public static float cauB(int n){
        if(n==0) return 0.5f;
        return (float)((n+1)/2.0+cauB(n-1));
    }
    public static float cauC(int n){
        if(n==1) return 1;
        return ((GT(n)/GT(n-1))+cauC(n-1));
    }
    public static float cauD(int n){
        if(n==1) return 0;
        return ((n*(n-1))+cauD(n-1));
    }
    public static void main(String[] args){
        System.out.println("cau a=" + cauA(2));
        System.out.println("cau b=" + cauB(2));
        System.out.println("cau c=" + cauC(2));
        System.out.println("cau d=" + cauD(2));
    }
}
