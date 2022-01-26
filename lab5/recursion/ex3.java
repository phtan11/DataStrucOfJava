package recursion;

public class ex3 {
    public static float cauA(int n){
        if(n==0) return 2;
        return (2-(1/2)*cauA(n-1));
    }
    public static float cauB(int n){
        if(n< 10) return 1;
        else return (1+cauB(n/10));
    }
    public static float cauC(int n,int k){
        if(k==1) return n;
        return (n+cauC(n,k-1));
    }
    public static float cauD(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return (cauD(n-1)+cauD(n-2));
    }
    public static void main(String[] args){
        System.out.println("cau a=" + cauA(2));
        System.out.println("cau b=" + cauB(2));
        System.out.println("cau c=" + cauC(2,5));
        System.out.println("cau d=" + cauD(2));
    }
}
