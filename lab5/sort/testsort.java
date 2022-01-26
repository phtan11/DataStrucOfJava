package sort;

import java.util.Arrays;

public class testsort {
    public static void inserSort(int a[],int n){ // tang dan
       for(int i =1;i<n;i++){
           int key = a[i];
           int j;
           for(j=i-1;j>=0 && a[j]< key;j--){
               a[j+1] = a[j];
           }
           a[j+1] = key;
       }
    }
    public static void bubbleSort(int a[],int n){ // giam dan
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(a[j] < a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
    public static void selecSorted(int a[],int n){
        for(int i =0;i<n-1;i++){
            int max = i;
            for(int j=i+1;j<n;j++){
                if(a[max] > a[j]){
                    max = j;
                }
            }
            int tmp = a[max];
            a[max] = a[i];
            a[i] = tmp;
        }
    }
    public static void main(String[] args){
        int a[] = {7,6,1,2,9,12,78,13};
        inserSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
