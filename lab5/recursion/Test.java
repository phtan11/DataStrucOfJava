package recursion;

public class Test {
    public static int bin2dec(int bin, int exp){
        if(bin==0) return 0;
        return (int)(bin%10*Math.pow(2,exp)) + bin2dec(bin/10,exp+1);
    }
    public static int dec2bin(int dec){
        if(dec==1) return 1;
        return dec%2+10*dec2bin(dec/2);
    }
    public static int maxDigit(int n){
        if(n==0) return 0;
        return Math.max(n%10,maxDigit(n/10));
    }
    public static int countDigit(int n){
        if(n/10==0) return 1;
        return 1+countDigit(n/10);
    }
    public static int maxElement(int a[], int n){
        if(n==1) return a[0];
        return Math.max(a[n-1], maxElement(a,n-1));
    }
    public static int minElement(int a[], int n){
        if(n==1) return a[0];
        return Math.min(a[n-1], minElement(a,n-1));
    }
    public static int search(int a[],int n,int key){
        if(n<0) return -1;
        if(a[n] == key) return 1;
        return search(a,n-1,key);
    }
    public static int countEven(int a[], int i){
        if(i==a.length) return 0;
        int count;
        if(a[i] %2==0) count=1;
        else count=0;
        return count+countEven(a, i+1);
    }
    public static boolean checkPrime(int n,int i){
        if(n<=2) return (n==2)?true:false;
        if(n%i==0) return false;
        if(i*i>n) return true;
        return checkPrime(n,i+1);
    }
    public static boolean checkSort(int a[],int n,int pos){
        if(pos == n-1) return true;
        else{
            if(a[pos] >a[pos+1]) return false;
            else return checkSort(a,n,pos+1);
        }
    }
    public static void main(String[] args){
        System.out.println(bin2dec(1110,0));
        System.out.println(dec2bin(14));
        System.out.println(maxDigit(1484653));
        System.out.println(countDigit(1484653));
        int a[] = {8,14,2,3,9,88,5,6,15};
        int b[] = {1,2,3,4,5,6,7,8};
        System.out.println(maxElement(a,a.length));
        System.out.println(minElement(a,a.length));
        System.out.println(search(a,a.length-1,54));
        System.out.println(countEven(a,0));
        System.out.println(checkPrime(9,2));
        System.out.println(checkSort(b,b.length,0));
    }
}
