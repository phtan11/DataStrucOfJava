public class Question1{
    public static int sumOfInteger(int n){
        if(n==0) return 0;
        return (n%10)+sumOfInteger(n/10);
    }
    public static int largestNumberOfArray(int[] a, int n){
        if(n==a.length-1) return a[a.length-1];
        return Math.max(a[n],largestNumberOfArray(a,n+1)); 
    }
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("sum of all of the digits of a positive integer: " + sumOfInteger(n));

        int a[] = {16,9,5,19,14,7};
        int max = largestNumberOfArray(a,0);
        System.out.println("the largest number in an array: " + max );
    }
}