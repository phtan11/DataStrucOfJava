package sort;

import java.util.Arrays;

public class selec {
    public static void selectionSort(int a[],int n){
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }
    public static void main(String[] args){
        int a[] ={2,9,5,10,7,6};
        int n = a.length;
        selectionSort(a,n);
        System.out.println(Arrays.toString(a));
    }
}
