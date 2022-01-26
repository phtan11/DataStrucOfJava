public class ex2 {
    public static int cauA(int n,int k){
        if(k==0) return 1;
        return n*cauA(n,k-1);
    }
    public static void main(String[] args){
        System.out.println(cauA(2,2));
    }
}
