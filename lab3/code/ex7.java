package code;
public class ex7 {
    // a min
    public static int minnArray(int a[],int n){
        if(n==1) return a[0];
        return Math.min(a[n-1],minnArray(a,n-1));
    }
    // b max
    public static int maxArray(int a[],int n){
        if(n==1) return a[0];
        return Math.max(a[n-1],maxArray(a,n-1));
    }
    //c count even numer
    public static int countEvenNumber(int[] a,int i){;
        if(i == a.length) return 0;
        int count = 0;
        if(a[i] %2 == 0) count=1;
        else count=0;
        return count+countEvenNumber(a, i+1);
    }
    public static void main(String[] args) {
        int a[] = {2,4,5,9,14,13};
        int min = minnArray(a,a.length);
        System.out.println("min :" + min );
        int max = maxArray(a,a.length);
        System.out.println("max :" + max );
        int count = countEvenNumber(a,0);
        System.out.println("amount of even number :" +count);
    }
}
