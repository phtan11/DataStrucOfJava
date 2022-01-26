package sort;

import java.util.Arrays;

public class inser {
    public static void inserSort(int a[],int n){
        for(int i=1;i<n;i++){
            int key = a[i];
            int j;
            for(j=i-1;j>=0 && a[j] > key;j--){
                a[j+1] = a[j];

            }
            a[j+1] = key;
        }
    }
    public static void main(String[] args){
        int a[] ={2,9,5,10,7,6};
        int n = a.length;
        inserSort(a,n);
        System.out.println(Arrays.toString(a));
    }
}
