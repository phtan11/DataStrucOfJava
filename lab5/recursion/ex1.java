package recursion;
public class ex1 {
    // public double prod_recur(int a, int b){

    // }
    public static int bin2dec(int bin, int exp){
        if(bin==0) return 0;
        return (int) ((bin%10)*Math.pow(2,exp) + bin2dec(bin/10,exp+1));
    }
    public static int dec2bin(int dec){
        if(dec == 1) return 1;
        return (dec%2 + 10*dec2bin(dec/2));
    }
    public static int maxDigit(int n){
        if(n==0) return 0;
        return Math.max(n%10,maxDigit(n/10));
    }
    public static int minDigit(int n){
        if(n ==0) return 0;
        return Math.min(n%10,minDigit(n/10));
    }
    public static int countDigit(int n){
        if(n/10==0) return 1;
        return (1+countDigit(n/10));
    }
    public static int maxElement(int a[], int n){
        if(n==1) return a[0];
        return Math.max(a[n-1],maxElement(a,n-1));
    }
    public static int minElement(int a[], int n){
        if(n==1) return a[0];
        return Math.min(a[n-1],minElement(a,n-1));
    }
    public static int search(int a[],int n,int key){
        if(n<0) return -1;
        if(a[n] == key) return 1;
        return search(a,n-1,key);
    }
    public static int countEven(int a[], int i){
        if(i == a.length) return 0;
        int count;
        if(a[i]%2==0) count= 1;
        else count= 0;
        return count+countEven(a,i+1);
    }
    public static void main(String[] arg){
        System.out.println("bin to dec:" + bin2dec(1010,0));
        System.out.println("dec to bin" + dec2bin(10));
        System.out.println("max=" + maxDigit(35945));
        System.out.println("" + minDigit(35945));
        System.out.println("amout of number:" + countDigit(35945));
        int []a = {2,4,10,8,15,1};
        int n = a.length;
        System.out.println("max of array=" + maxElement(a,n));
        System.out.println("min of array=" + minElement(a,n));
        System.out.println("amout even of array=" + countEven(a,0));
        System.out.println("value has exist or not:" + search(a,n-1,10));
    }
}
