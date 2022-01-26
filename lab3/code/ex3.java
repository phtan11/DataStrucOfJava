package code;
public class ex3 {
    public static boolean checkPrime(int n,int i){
        if(n <= 2) return (n==2)?true:false;
        if(n%i==0) return false;
        if(i*i >n) return true;
        return checkPrime(n,i+1);
    }
    public static void main(String[] args){
        if(checkPrime(3,2)) System.out.println("number is prime");
        else System.out.println("number isn't prime");
    }
}
