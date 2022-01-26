package sort;

import java.util.Arrays;

public class bubble {
    public static void bubbleSort(int a[],int n){
        for(int i=0;i<n;i++){
            for(int j=n-1;j>0;j--){
                if(a[j]<a[j-1]){
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;   
                }
            }
            
        }
    }
    public static void main(String[] args){
        int a[] ={2,9,5,10,7,6};
        int n = a.length;
        bubbleSort(a,n);
        System.out.println(Arrays.toString(a));
    }
}
